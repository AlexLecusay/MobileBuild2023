package com.example.roaryminder.android.ui.ChatScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(
    viewModel: RoaryViewModel,
    classes: List<RoaryRepoInfo>,
    classIndex: String?,
    assignmentIndex: String?,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 5.dp
            ) {
                Text(text = "Home")
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            val messagesToDisplay = classes[classIndex!!.toInt()].classAssignments?.get(assignmentIndex!!.toInt())?.chatRepo?.messages as List<String>

            LazyColumn(
                Modifier
                    .weight(1f)
                    .padding(bottom = 4.dp)) {
                items(messagesToDisplay) { message ->
                    Message(message = message)
                }
            }

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
                    label = { Text("Send Message") }
                )
                TextButton(
                    onClick = {
                        if (assignmentIndex != null) {
                            viewModel.saveMessage(
                                message.value,
                                classes[classIndex.toInt()].classAssignments?.get(assignmentIndex.toInt()) as Assignments
                            )
                            message.value = ""
                        }
                    }) {
                    Text(text = "Send", style = MaterialTheme.typography.h6)
                }
            }
        }

    }
}

@Composable
fun Message(message: String) {
    Text(
        text = message,
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colors.primary, shape = MaterialTheme.shapes.medium)
            .padding(8.dp),
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onPrimary
    )
}