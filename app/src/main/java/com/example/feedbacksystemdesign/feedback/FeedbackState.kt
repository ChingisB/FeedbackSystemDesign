package com.example.feedbacksystemdesign.feedback

data class FeedbackState(
    val rating: Float = 0f,
    val options: List<String> = listOf(),
    val activeOptions: List<String> = listOf(),
    val isOthersClicked: Boolean = false,
    val comment: String = ""
)
