package com.example.mvi.first.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mvi.databinding.FragmentFirstBinding
import com.example.mvi.first.presentation.event.FirstScreenEvent
import com.example.mvi.first.presentation.intent.FirstScreenOperationIntent
import com.example.mvi.first.presentation.operation.NextActionArg
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FirstScreenFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<FirstScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState
            .flowWithLifecycle(lifecycle)
            .onEach(::render)
            .launchIn(lifecycleScope)

        viewModel.events
            .flowWithLifecycle(lifecycle)
            .onEach(::react)
            .launchIn(lifecycleScope)

        binding.refreshLayout.setOnRefreshListener {
            viewModel.handleUserIntent(FirstScreenOperationIntent.PULL_TO_REFRESH)
        }
        binding.buttonRetry.setOnClickListener {
            viewModel.handleUserIntent(FirstScreenOperationIntent.INITIAL_LOADING)
        }
        binding.buttonFirst.setOnClickListener {
            viewModel.handleUserIntent(
                FirstScreenOperationIntent.NEXT_BUTTON_CLICK,
                NextActionArg(it.hashCode())
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun render(viewState: FirstScreenViewState) {
        binding.refreshLayout.isEnabled = viewState.isRefreshEnabled
        binding.refreshLayout.isRefreshing = viewState.isRefreshLoading

        binding.progress.isVisible = viewState.isInitialLoading

        binding.buttonRetry.isVisible = viewState.isRetryButtonVisible
        binding.buttonFirst.isVisible = viewState.isNextButtonVisible

        binding.textviewContent.setTextColor(viewState.contentColor)
        binding.textviewContent.text = viewState.content

        binding.textviewError.text = viewState.error
        binding.textviewError.isVisible = viewState.isErrorVisible

    }

    private fun react(event: FirstScreenEvent) = when (event) {
        is FirstScreenEvent.NavigateTo -> findNavController().navigate(event.screenId)
        is FirstScreenEvent.ShowSneck -> showSnackbar(event.text)
    }

    private fun showSnackbar(text: String) {
        Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_SHORT
        ).setAction("Action", null).show()
    }
}