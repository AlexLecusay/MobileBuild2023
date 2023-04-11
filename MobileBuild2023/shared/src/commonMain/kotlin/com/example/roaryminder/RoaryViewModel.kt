package com.example.roaryminder

import com.example.roaryminder.repo.*
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RoaryViewModel: KMMViewModel() {

    val projectTitle = "Roaryminder"
    private val repo = RoaryRepo()

    lateinit var queries: Flow<List<String>>

    init {
        viewModelScope.coroutineScope.launch {
            repo.startSync()

            var testChat = ChatRepos(realmListOf("Message one", "Message two"))
            var testAssignment = Assignments("Testname", "Testdescription", testChat)
            var testClass = RoaryRepoInfo().apply {
                className = "Testclass"
                classDescription = "Testdescription"
                classAssignments = realmListOf(testAssignment) }
            saveQuery(testClass)
            //queries = repo.getAllData()
            print("THE QUERIES ARE: $queries")
        }
    }

    fun saveQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveInfo(classForRepo)
        }
    }

    fun loadClasses(): List<Class> {
        return listOf(
            Class(
                className = "History 101",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = realmListOf(
                    Assignments(
                        "Homework for 101",
                        "This is the second homework",
                        ChatRepos(realmListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 202",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = realmListOf(
                    Assignments(
                        "Homework for 202",
                        "This is the second homework",
                        ChatRepos(realmListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 105",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = realmListOf(
                    Assignments(
                        "Homework for 105",
                        "This is the second homework",
                        ChatRepos(realmListOf("Message one", "Message two"))
                    )
                )
            ),
            Class(
                className = "History 104",
                classDescription = "Learn about ancient civilizations and their impact on modern society.",
                classAssignments = realmListOf(
                    Assignments(
                        "Homework 104",
                        "This is the second homework",
                        ChatRepos(realmListOf("Message one", "Message two"))
                    ),
                    Assignments(
                        "Homework 104",
                        "This is the second homework",
                        ChatRepos(realmListOf("Message one", "Message two"))
                    )
                )
            ),
        )
    }
}
