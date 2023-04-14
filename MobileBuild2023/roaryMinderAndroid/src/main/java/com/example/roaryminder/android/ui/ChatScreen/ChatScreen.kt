package com.example.roaryminder.android.ui.ChatScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.repo.Assignments
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
                .height(56.dp)
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val message = remember { mutableStateOf("") }
            TextField(
                value = message.value,
                onValueChange = {message.value = it},
                label = { Text("Assignment Name") }
            )
            TextButton(onClick = {
                if (assignmentIndex != null) {
                    viewModel.saveMessage(
                        message.value,
                        classes[classIndex.toInt()].classAssignments?.get(assignmentIndex.toInt()) as Assignments
                    )
                }
            }) {
                Text(text = "Add")
            }
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