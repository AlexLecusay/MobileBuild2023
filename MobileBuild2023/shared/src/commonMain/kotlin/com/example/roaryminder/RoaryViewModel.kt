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

//            var testClass = RoaryRepoInfo().apply {
//                className = "Testclass"
//                classDescription = "Test description"
//                classAssignments = realmListOf(
//                    Assignments().apply {
//                    assignmentName = "Homework for 101"
//                    assignmentDescription = "This is the second homework"
//                    chatRepo =
//                        ChatRepos().apply {
//                        messages = realmListOf("Message one", "Message two")
//                        }
//                    }
//                )
//            }
//            saveQuery(testClass)
            //queries = repo.getAllData()
            //print("THE QUERIES ARE: $queries")
        }
    }

    fun saveQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveInfo(classForRepo)
        }
    }

    fun loadClasses(): List<RoaryRepoInfo> {
        return listOf(
            RoaryRepoInfo().apply {
                className = "History 101"
                classDescription = "Learn about ancient civilizations and their impact on modern society."
                classAssignments = realmListOf(
                    Assignments().apply {
                        assignmentName = "Homework for 101"
                        assignmentDescription = "This is the second homework"
                        chatRepo = ChatRepos().apply {
                            messages = realmListOf("Message one", "Message two")
                        }
                    })
            },
            RoaryRepoInfo().apply {
                className = "History 102"
                classDescription = "Learn about ancient civilizations and their impact on modern society."
                classAssignments = realmListOf(
                    Assignments().apply {
                        assignmentName = "Homework for 101"
                        assignmentDescription = "This is the second homework"
                        chatRepo = ChatRepos().apply {
                            messages = realmListOf("Message one", "Message two")
                        }
                    })
            },
            RoaryRepoInfo().apply {
                className = "History 103"
                classDescription = "Learn about ancient civilizations and their impact on modern society."
                classAssignments = realmListOf(
                    Assignments().apply {
                        assignmentName = "Homework for 101"
                        assignmentDescription = "This is the second homework"
                        chatRepo = ChatRepos().apply {
                            messages = realmListOf("Message one", "Message two")
                        }
                    })
            })
    }
}
