package com.example.roaryminder.android.ui.HomeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.android.R
import com.example.roaryminder.android.navigation.Screens
import com.example.roaryminder.repo.RoaryRepoInfo

@Composable
fun ClassCardList(
    navController: NavController,
    classes: List<com.example.roaryminder.repo.RoaryRepoInfo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(classes){
                currClass ->
            ClassCardComponent(currentClass = currClass){ name ->
                navController.navigate(Screens.TopicScreen.name+"/$name")
            }
        }
    }
}
@Composable
fun ClassCardComponent(
    currentClass: com.example.roaryminder.repo.RoaryRepoInfo,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onItemClick(currentClass.className) },
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

                if (true)
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen (navController: NavController, viewModel: RoaryViewModel){
    val roaryRepoInfoList: List<RoaryRepoInfo> by viewModel.roaryRepoInfoList.collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 5.dp
            ) {
                Text(text = "Home")
            }
        }
    ){
        ClassCardList(navController = navController, roaryRepoInfoList)
    }
}