package com.example.roaryminder.android.ui.TopicScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.android.navigation.Screens
import com.example.roaryminder.repo.Assignments
import com.example.roaryminder.repo.ChatRepos
import com.example.roaryminder.repo.RoaryRepoInfo
import io.realm.kotlin.ext.realmListOf
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopicScreen(
    viewModel: RoaryViewModel,
    navController: NavController,
    classes: List<RoaryRepoInfo>,
    classIndex: String?
){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    if (classIndex != null) {
                        Text(text = classes[classIndex.toInt()].className)
                    }
                    val showDialog = remember { mutableStateOf(false) }
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add",
                        tint = Color.Green,
                        modifier = Modifier
                            .width(24.dp)
                            .clickable {
                                showDialog.value = true
                            }
                    )
                    AddAssignmentDialog(
                        showDialog = showDialog.value,
                        onDismiss = { showDialog.value = false },
                        onAddClicked = { assignment, assDescription ->
                            if (classIndex != null) {
                                viewModel.saveAssignment(
                                    Assignments().apply {
                                        assignmentName = assignment
                                        assignmentDescription = assDescription
                                        chatRepo = ChatRepos().apply {
                                                messages = realmListOf("")
                                            }
                                    },
                                    classes[classIndex.toInt()])
                            }
                            showDialog.value = false
                        }
                    )
                }
            }
        }
    ) {
        TopicCardList(
            navController = navController,
            viewModel = viewModel,
            classes = classes,
            assignments = classes[classIndex!!.toInt()].classAssignments as List<Assignments>,
            classIndex = classIndex)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardList(
    navController: NavController,
    viewModel: RoaryViewModel,
    classes: List<RoaryRepoInfo>,
    assignments: List<Assignments>,
    classIndex: String?
) {
    var count = 0
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        if (classIndex != null) {
            items(assignments){ assignment ->
                TopicCardComponent(
                    viewModel = viewModel,
                    assignment = assignment,
                    classes = classes,
                    classIndex = classIndex,
                    assignmentIndex = count++)
                { classIndex, assignmentIndex ->
                    navController.navigate(
                        Screens.ChatScreen.name+"/$classIndex/$assignmentIndex"
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardComponent(
    viewModel: RoaryViewModel,
    assignment: Assignments,
    assignmentIndex: Int,
    classes: List<RoaryRepoInfo>,
    classIndex: String?,
    onItemClick: (String, String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                if (classIndex != null) {
                    onItemClick(
                        classIndex,
                        assignmentIndex.toString(),
                    )
                }
            },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(.85f)
            ) {
                Text(
                    text = assignment.assignmentName,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = assignment.assignmentDescription,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.Delete,
                tint = Color.Red,
                contentDescription = "Bell",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth()
                    .size(48.dp)
                    .clickable {
                        if (classIndex != null) {
                            viewModel.deleteAssignment(
                                assignment,
                                classes[classIndex.toInt()])
                        }
                    }
                )
        }
    }
}

@Composable
fun AddAssignmentDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onAddClicked: (String, String) -> Unit
) {
    val assignment = remember { mutableStateOf("") }
    val assignmentDescription = remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Add Assignment")
            },
            text = {
                Column {
                    TextField(
                        value = assignment.value,
                        onValueChange = {assignment.value = it},
                        label = { Text("Assignment Name") }
                    )
                    TextField(
                        value = assignmentDescription.value,
                        onValueChange = {assignmentDescription.value = it},
                        label = { Text("Description") }
                    )
                }
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {
                        onAddClicked(
                            assignment.value,
                            assignmentDescription.value)
                    }) {
                        Text(text = "Add")
                    }
                }
            }
        )
    }
}
