package com.example.feedbacksystemdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.feedbacksystemdesign.databinding.ComposeScreenBinding
import com.example.feedbacksystemdesign.feedback.FeedbackBottomSheet
import com.example.feedbacksystemdesign.ui.theme.FeedbackSystemDesignTheme

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ComposeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComposeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.composeView.setContent {
            FeedbackSystemDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Button(onClick = { FeedbackBottomSheet().show(supportFragmentManager, null) }) {
                        Text("clicke me!")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeedbackSystemDesignTheme {
        Greeting("Android")
    }
}