package com.example.roaryminder.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.repo.Assignment
import com.example.roaryminder.repo.ChatRepo
import com.example.roaryminder.repo.Class

@Composable
fun ClassCardComponent(
    classTitle: String?,
    classDescription: String?,
    classImage: Painter,
    isHomePage: Boolean
) {
    val classTitle by remember { mutableStateOf(classTitle) }
    val classDescription by remember { mutableStateOf(classDescription) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Column {
            Image(
                painter = classImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Text(
                text = classTitle.toString(),
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
                    text = classDescription.toString(),
                    style = MaterialTheme.typography.body2,

                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
                        .fillMaxWidth(.85f)
                )

                if (!isHomePage)
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "add",
                        tint = Color.Blue,
                        modifier = Modifier
                            .padding(end = 16.dp, bottom = 8.dp)
                            .fillMaxWidth()

                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClassCardComponent1(

    class1: com.example.roaryminder.repo.Class,
    modifier: Modifier =Modifier
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
        onClick = {}
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
                text = class1.className,
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
                    text = class1.classDescription,
                    style = MaterialTheme.typography.body2,

                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
                        .fillMaxWidth(.85f)
                )

                if (true)
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "add",
                        tint = Color.Blue,
                        modifier = Modifier
                            .padding(end = 16.dp, bottom = 8.dp)
                            .fillMaxWidth()

                    )
            }
        }
    }
}

//preview of ClassCardComponent1
@Preview
@Composable
fun ClassCardComponent1Preview() {
    ClassCardComponent1(
        Class(
        "COP1234",
        "This is a class",
        mutableListOf(
            Assignment(
                "Homework 2",
                "This is the second homework",
                ChatRepo(mutableListOf("Message one", "Message two"))
            )
        )
    )
    )
}

@Composable
fun ClassCardList(
    classes: List<com.example.roaryminder.repo.Class>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
       items(classes){
           class1 ->
              ClassCardComponent1(class1 = class1)
       }
    }
}

@Preview
@Composable
fun ClassCardListPreview(

){
    ClassCardList(classes = RoaryViewModel().loadClasses())
}

