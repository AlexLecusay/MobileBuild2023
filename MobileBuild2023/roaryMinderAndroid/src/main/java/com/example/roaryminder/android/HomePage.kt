package com.example.roaryminder.android

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.roaryminder.RoaryViewModel

@Composable
fun HomePage(
    viewModel: RoaryViewModel
){
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Classes")},backgroundColor = MaterialTheme.colors.primary)  },
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { ClassCardList(classes = RoaryViewModel().loadClasses()) }

    )
}


@Preview
@Composable
fun HomePagePreview(){
    HomePage( viewModel = RoaryViewModel() )
}

//ClassCardList(classes = RoaryViewModel().loadClasses())