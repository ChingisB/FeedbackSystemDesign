package com.example.feedbacksystemdesign.feedback

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FeedbackViewModel(private val stateHandle: SavedStateHandle) : ViewModel(), FeedbackCallbacks {

    private val _state = MutableStateFlow(FeedbackState(options = listOf("Friendly interface", "Reliability", "Speed of service")))
    val state: StateFlow<FeedbackState> = _state


    override fun onRatingChanged(rating: Float) = _state.update { it.copy(rating = rating) }

    override fun onOptionClicked(option: String) {
        if (_state.value.activeOptions.contains(option)) {
            _state.update { it.copy(activeOptions = it.activeOptions.dropWhile { activeOption -> activeOption == option }) }
        } else {
            _state.update { it.copy(activeOptions = it.activeOptions.plus(option)) }
        }
    }

    override fun onCommentChange(comment: String) = _state.update { it.copy(comment = comment) }

    override fun onSendButtonClicked() = Unit
}