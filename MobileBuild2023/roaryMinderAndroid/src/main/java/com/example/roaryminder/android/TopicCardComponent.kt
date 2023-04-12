package com.example.roaryminder.android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardComponent(
    notificationTitle: String,
    dueDate: LocalDateTime

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
                    text = notificationTitle,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = formatter.format(dueDate),
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


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopicCardList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        repeat(15) {
            item {
                TopicCardComponent(
                    notificationTitle = "Test 1",
                    dueDate = LocalDateTime.of(2023, 3, 30, 14, 30)
                )
            }
        }
    }
}