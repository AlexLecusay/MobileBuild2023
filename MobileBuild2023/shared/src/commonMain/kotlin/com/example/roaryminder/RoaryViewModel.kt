package com.example.roaryminder

import com.example.roaryminder.repo.Assignment
import com.example.roaryminder.repo.ChatRepo
import com.example.roaryminder.repo.Class
import com.example.roaryminder.repo.RoaryRepo
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.launch

class RoaryViewModel: KMMViewModel() {

    val projectTitle = "Roaryminder"
    private val repo = RoaryRepo()

    lateinit var queries: List<String>

    init {
        viewModelScope.coroutineScope.launch {
            queries = repo.getAllData()
        }
    }
    fun saveQuery(query: String) {
        viewModelScope.coroutineScope.launch {
            repo.saveInfo(query)
        }
    }

    fun loadClasses(): List<Class> {
        saveQuery("Testing from android")
        saveQuery("Testing from android")
        saveQuery("Testing from android")

        return listOf(
            Class(
                className = "History 101",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = mutableListOf(
                    Assignment(
                        "Homework for 101",
                        "This is the second homework",
                        ChatRepo(mutableListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 202",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = mutableListOf(
                    Assignment(
                        "Homework for 202",
                        "This is the second homework",
                        ChatRepo(mutableListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 105",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = mutableListOf(
                    Assignment(
                        "Homework for 105",
                        "This is the second homework",
                        ChatRepo(mutableListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 104",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = mutableListOf(
                    Assignment(
                        "Homework 104",
                        "This is the second homework",
                        ChatRepo(mutableListOf("Message one", "Message two"))
                    ),
                    Assignment(
                        "Homework 104",
                        "This is the second homework",
                        ChatRepo(mutableListOf("Message one", "Message two"))
                    )
                )
            ),
        )
    }
}
