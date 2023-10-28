package com.example.feedbacksystemdesign.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feedbacksystemdesign.R
import com.example.feedbacksystemdesign.ui.theme.FeedbackSystemDesignTheme
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig


@[Composable OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)]
fun FeedbackBottomSheetContent(state: FeedbackState, callbacks: FeedbackCallbacks) {

    val ratingBarConfig = RatingBarConfig().size(48.dp)

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        Arrangement.spacedBy(32.dp),
        Alignment.CenterHorizontally
    ) {

        RatingBar(
            value = state.rating,
            config = ratingBarConfig,
            onValueChange = callbacks::onRatingChanged,
            onRatingChanged = { Unit })

        Text(stringResource(R.string.feedback_reason))

        FlowRow(
            Modifier.fillMaxWidth(),
            Arrangement.spacedBy(8.dp),
            Alignment.CenterVertically
        ) {
            state.options.forEach {
                Option(it, state.activeOptions.contains(it), callbacks::onOptionClicked)
            }
        }

        OutlinedTextField(value = state.comment, onValueChange = callbacks::onCommentChange, placeholder = {
            Text(stringResource(id = R.string.feedback_please_enter))
        })
        Button(onClick = callbacks::onSendButtonClicked) {
            Text(stringResource(R.string.feedback_send))
        }
    }
}

@Composable
fun Option(name: String, isActive: Boolean, onClick: (String) -> Unit) {
    if (!isActive) {
        OutlinedButton(onClick = { onClick.invoke(name) }) {
            Text(name)
        }
    } else {
        Button(onClick = { onClick.invoke(name) }) {
            Text(name)
        }
    }
}

@[Composable Preview]
fun OptionsPreview() {
    val state = FeedbackState(
        options = listOf("lol", "kek", "cool", "nice", "top", "I absolutely enjoyed this staff!!"), activeOptions = listOf("lol", "kek")
    )
    val callbacks = object : FeedbackCallbacks {}
    FeedbackSystemDesignTheme {
        Surface {
            FeedbackBottomSheetContent(state = state, callbacks = callbacks)
        }
    }
}