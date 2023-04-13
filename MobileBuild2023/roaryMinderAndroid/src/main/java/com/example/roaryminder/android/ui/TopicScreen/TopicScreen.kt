package com.example.roaryminder.android.ui.TopicScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roaryminder.repo.Assignments
import com.example.roaryminder.repo.RoaryRepoInfo
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopicScreen(
    navController: NavController,
    classes: List<RoaryRepoInfo>,
    classIndex: String?
){
    println("I AM THE CLASS INDEX: $classIndex")
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 5.dp
            ) {
                if (classIndex != null) {
                    Text(text = classes[classIndex.toInt()].className)
                }
            }
        }
    ) {
        TopicCardList(classes[classIndex!!.toInt()].classAssignments as List<Assignments>, classIndex)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardList(
    assignments: List<Assignments>,
    classIndex: String?
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        if (classIndex != null) {
            items(assignments){ assignment ->
                TopicCardComponent(assignment)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardComponent(
    assignment: Assignments,
) {
    val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm a")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
                imageVector = Icons.Default.Notifications,
                contentDescription = "Bell",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth()
                    .size(48.dp),

                )
        }
    }
}