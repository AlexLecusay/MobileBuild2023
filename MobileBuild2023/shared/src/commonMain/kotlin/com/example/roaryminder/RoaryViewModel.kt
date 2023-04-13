package com.example.roaryminder

import com.example.roaryminder.repo.*
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class RoaryViewModel: KMMViewModel() {

    val projectTitle = "Roaryminder"
    private val repo = RoaryRepo()
    private val _roaryRepoInfoList: MutableStateFlow<List<RoaryRepoInfo>> = MutableStateFlow(emptyList())
    val roaryRepoInfoList: Flow<List<RoaryRepoInfo>> get() = _roaryRepoInfoList

    init {
        viewModelScope.coroutineScope.launch {
            repo.startSync()
            repo.clearDatabase()

            val testClass = RoaryRepoInfo().apply {
                className = "COP420"
                classDescription = "Lets get this bread"
                classAssignments = realmListOf(
                    Assignments().apply {
                    assignmentName = "Online Homework"
                    assignmentDescription = "Due 9/1/2021"
                    chatRepo =
                        ChatRepos().apply {
                        messages = realmListOf(
                            "This is a bit difficult",
                            "Are you stuck on problem 1?")
                        }
                    }
                )
            }
            saveQuery(testClass)
            val testClass2 = RoaryRepoInfo().apply {
                className = "COP6999"
                classDescription = "Lets get this bread"
                classAssignments = realmListOf(
                    Assignments().apply {
                        assignmentName = "Online Homework"
                        assignmentDescription = "Due 9/1/2021"
                        chatRepo =
                            ChatRepos().apply {
                                messages = realmListOf(
                                    "This is a bit difficult",
                                    "Are you stuck on problem 1?")
                            }
                    }
                )
            }
            saveQuery(testClass2)
            loadClasses()
        }
    }

    fun saveQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveClass(classForRepo)
        }
    }

    fun loadClasses() {
        viewModelScope.coroutineScope.launch {
            repo.getAllData().collect{
                _roaryRepoInfoList.value = it
            }
        }
    }
}
