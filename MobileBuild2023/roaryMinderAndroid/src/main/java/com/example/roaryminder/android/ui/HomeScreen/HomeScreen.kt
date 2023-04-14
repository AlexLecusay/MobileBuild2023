package com.example.roaryminder.android.ui.HomeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.android.R
import com.example.roaryminder.android.navigation.Screens
import com.example.roaryminder.repo.Assignments
import com.example.roaryminder.repo.ChatRepos
import com.example.roaryminder.repo.RoaryRepoInfo
import io.realm.kotlin.ext.realmListOf

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: RoaryViewModel,
    navController: NavController,
    classes: List<RoaryRepoInfo>
){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 5.dp,
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                    Image(
                        painter = painterResource(id = R.drawable.roaryminderlogo),
                        contentDescription = "Roary",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    Text(text = viewModel.projectTitle)
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
                    AddClassDialog(
                        showDialog = showDialog.value,
                        onDismiss = { showDialog.value = false },
                        onAddClicked = { name, description, assignment, assDescription ->
                            val newClass = RoaryRepoInfo().apply {
                                className = name
                                classDescription = description
                                classAssignments = realmListOf(
                                    Assignments().apply {
                                        assignmentName = assignment
                                        assignmentDescription = assDescription
                                        chatRepo =
                                            ChatRepos().apply {
                                                messages = realmListOf("")
                                            }
                                    }
                                )
                            }
                            viewModel.saveQuery(newClass)
                            showDialog.value = false
                        }
                    )
                }
            }
        }
    ){
        ClassCardList(
            viewModel = viewModel,
            navController = navController,
            classes = classes)
    }
}

@Composable
fun ClassCardList(
    viewModel: RoaryViewModel,
    navController: NavController,
    classes: List<RoaryRepoInfo>,
    modifier: Modifier = Modifier
) {
    var count = 0
    LazyColumn(modifier = modifier) {
        items(classes){
                currClass ->
            ClassCardComponent(
                viewModel = viewModel,
                currentClass = currClass,
                //classes = classes,
                index = count++){ name ->
                navController.navigate(Screens.TopicScreen.name+"/$name")
            }
        }
    }
}

@Composable
fun ClassCardComponent(
    viewModel: RoaryViewModel,
    currentClass: RoaryRepoInfo,
    index: Int,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onItemClick(
                    index.toString()
                )
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.sample),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Text(
                text = currentClass.className,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
            Divider(
                color = Color.Gray.copy(alpha = 0.3f),
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = currentClass.classDescription,
                    style = MaterialTheme.typography.body2,

                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
                        .fillMaxWidth(.85f)
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete",
                    tint = Color.Red,
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            viewModel.deleteQuery(currentClass)
                        }
                )
            }
        }
    }
}

@Composable
fun AddClassDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onAddClicked: (String, String, String, String) -> Unit
) {
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val assignment = remember { mutableStateOf("") }
    val assignmentDescription = remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Add Class")
            },
            text = {
                Column {
                    TextField(
                        value = name.value,
                        onValueChange = {name.value = it},
                        label = { Text("Class Name") }
                    )
                    TextField(
                        value = description.value,
                        onValueChange = {description.value = it},
                        label = { Text("Class Description") }
                    )
                    TextField(
                        value = assignment.value,
                        onValueChange = {assignment.value = it},
                        label = { Text("At least one Assignment") }
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
                            name.value,
                            description.value,
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
