package com.example.roaryminder.android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roaryminder.RoaryViewModel
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoaryNavHost(viewModel: RoaryViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomePage(viewModel = viewModel) }
        composable("topic") { TopicPage(viewModel = viewModel) }

    }
}