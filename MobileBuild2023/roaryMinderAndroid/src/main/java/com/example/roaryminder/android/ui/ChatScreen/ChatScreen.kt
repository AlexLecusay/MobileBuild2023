package com.example.roaryminder.android.ui.ChatScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.repo.RoaryRepoInfo

@Composable
fun ChatScreen(
    viewModel: RoaryViewModel,
    classes: List<RoaryRepoInfo>,
    classIndex: String?,
    assignmentIndex: String?,
    ) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        val messagesToDisplay = classes[classIndex!!.toInt()].classAssignments?.get(assignmentIndex!!.toInt())?.chatRepo?.messages as List<String>
        Column(Modifier.weight(1f)) {
            messagesToDisplay.forEach {
                Message(message = it)
            }
        }
        // Display input field for new messages
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Input field for new messages
            Text(
                text = "Type your message here...",
                style = MaterialTheme.typography.body1.copy(color = Color.Gray),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )
            // Send button
            Text(
                text = "SEND",
                style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Composable
fun Message(message: String) {
    Text(
        text = message,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}