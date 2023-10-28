package com.example.feedbacksystemdesign.feedback

interface FeedbackCallbacks{

    fun onRatingChanged(rating: Float) = Unit

    fun onOptionClicked(option: String) = Unit

    fun onCommentChange(comment: String) = Unit

    fun onSendButtonClicked() = Unit
}