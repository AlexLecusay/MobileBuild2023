package com.example.roaryminder

import com.example.roaryminder.repo.*
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class RoaryViewModel: KMMViewModel() {

    val projectTitle = "Roaryminder"
    private val repo = RoaryRepo()

    var roaryMinderQueries: MutableStateFlow<List<RoaryRepoInfo>> = MutableStateFlow(listOf(RoaryRepoInfo()))

    init {
        viewModelScope.coroutineScope.launch {
            repo.startSync()

            val testClass = RoaryRepoInfo().apply {
                className = "Testclass"
                classDescription = "Test description"
                classAssignments = realmListOf(
                    Assignments().apply {
                    assignmentName = "Homework for 101"
                    assignmentDescription = "This is the second homework"
                    chatRepo =
                        ChatRepos().apply {
                        messages = realmListOf("Message one", "Message two")
                        }
                    }
                )
            }
            saveQuery(testClass)
            val testClass2 = RoaryRepoInfo().apply {
                className = "BLAH BLAH"
                classDescription = "Test description BLAH"
                classAssignments = realmListOf(
                    Assignments().apply {
                        assignmentName = "Homework for BLAH"
                        assignmentDescription = "This is the second homework"
                        chatRepo =
                            ChatRepos().apply {
                                messages = realmListOf("Message one", "Message two")
                            }
                    }
                )
            }
            saveQuery(testClass2)
            roaryMinderQueries = MutableStateFlow(loadClasses())
            print("THE QUERIES ARE: $roaryMinderQueries")

        }
    }

    fun saveQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveInfo(classForRepo)
        }
    }

    fun loadClasses(): List<RoaryRepoInfo> {
        var roaryRepoList = mutableListOf<RoaryRepoInfo>()
        viewModelScope.coroutineScope.launch {
            roaryRepoList = repo.getAllData().toList().last() as MutableList<RoaryRepoInfo>
        }
        return roaryRepoList
    }
}
