package com.example.feedbacksystemdesign.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.example.feedbacksystemdesign.R
import com.example.feedbacksystemdesign.databinding.ComposeScreenBinding
import com.example.feedbacksystemdesign.ui.theme.FeedbackSystemDesignTheme
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FeedbackBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ComposeScreenBinding
    private val viewModel by viewModels<FeedbackViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ComposeScreenBinding.inflate(inflater)
        binding.setupComposeView()

        return binding.root
    }

    override fun getTheme(): Int = R.style.Theme_FeedbackSystemDesign

    private fun ComposeScreenBinding.setupComposeView() = composeView.setContent {
        val state by viewModel.state.collectAsState()
        FeedbackSystemDesignTheme {
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .padding(horizontal = 8.dp)
            ) {
                FeedbackBottomSheetContent(state = state, callbacks = viewModel)
            }
        }
    }
}