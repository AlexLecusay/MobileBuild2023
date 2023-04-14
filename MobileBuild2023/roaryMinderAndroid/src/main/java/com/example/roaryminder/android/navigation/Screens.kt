package com.example.roaryminder.android.navigation

enum class Screens {
    HomeScreen,
    TopicScreen,
    ChatScreen;
    companion object{
        fun fromRoute(route: String?): Screens
            =when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                TopicScreen.name -> TopicScreen
                ChatScreen.name -> ChatScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")

            }

    }
}