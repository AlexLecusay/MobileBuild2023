package com.example.roaryminder.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roaryminder.RoaryViewModel
import com.example.roaryminder.android.ui.HomeScreen.HomeScreen
import com.example.roaryminder.android.ui.TopicScreen.TopicScreen


@Composable
fun RoaryNavigation(viewModel: RoaryViewModel) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name ){
        composable(Screens.HomeScreen.name){
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screens.TopicScreen.name+"/{class}",
            arguments = listOf(navArgument(name = "class") {type = NavType.StringType})
        ){
            backStackEntry ->
            TopicScreen(navController = navController, backStackEntry.arguments?.getString("class"))
        }
        composable(Screens.ChatScreen.name){

        }
    }
}