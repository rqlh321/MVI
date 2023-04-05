package com.example.mvi.first.domain

import android.graphics.Color
import javax.inject.Inject
import kotlin.random.Random

class TextGenerationInteractorImpl @Inject constructor(
    private val repo: TextRepository
) : TextGenerationInteractor {
    override suspend fun generate(): GeneratedText {
        val sourceText = repo.text()
        return GeneratedText(
            text = mutateText(sourceText),
            color = Color.parseColor(generateColor())
        )
    }

    private fun generateColor(): String {
        val alpha = Integer.toHexString(255)
        val red = Integer.toHexString(Random.nextInt(255))
        val green = Integer.toHexString(Random.nextInt(255))
        val blue = Integer.toHexString(Random.nextInt(255))
        return "#$alpha$red$green$blue"
    }

    private fun mutateText(text: String): String {
        return text.replace("?", "???")
    }
}