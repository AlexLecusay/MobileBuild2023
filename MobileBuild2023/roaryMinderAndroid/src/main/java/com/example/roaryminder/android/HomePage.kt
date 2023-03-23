package com.example.roaryminder.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.roaryminder.RoaryViewModel

@Composable
fun HomePage(
    viewModel: RoaryViewModel
){
    Text(
        text = viewModel.projectTitle,
        modifier = Modifier
            .size(25.dp)
            .padding(bottom = 10.dp),
        textAlign = TextAlign.Center,

    )
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {
        items(viewModel.fakeClasses.size) { fakeClass ->
            ClassCardComponent(
                classTitle = viewModel.fakeClasses[fakeClass].className,
                classDescription = viewModel.fakeClasses[fakeClass].classDescription,
                classImage = painterResource(id = R.drawable.sample),
                isHomePage = true
            )
        }
    }
}