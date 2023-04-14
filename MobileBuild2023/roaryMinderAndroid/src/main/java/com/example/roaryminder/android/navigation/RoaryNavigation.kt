package com.example.roaryminder.android.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.android.ui.HomeScreen.HomeScreen
import com.example.roaryminder.android.ui.TopicScreen.TopicScreen
import com.example.roaryminder.repo.RoaryRepoInfo


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoaryNavigation(viewModel: RoaryViewModel) {
    val navController = rememberNavController()
    val roaryRepoInfoList: List<RoaryRepoInfo> by viewModel.roaryRepoInfoList.collectAsState(emptyList())

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name ){
        composable(Screens.HomeScreen.name){
            HomeScreen(
                viewModel = viewModel,
                navController = navController,
                classes = roaryRepoInfoList)
        }
        composable(Screens.TopicScreen.name+"/{class}",
            arguments = listOf(navArgument(name = "class") {type = NavType.StringType})
        ){
            backStackEntry ->
            TopicScreen(
                navController = navController,
                classes = roaryRepoInfoList,
                backStackEntry.arguments?.getString("class"))
        }
        composable(Screens.ChatScreen.name){

        }
    }
}