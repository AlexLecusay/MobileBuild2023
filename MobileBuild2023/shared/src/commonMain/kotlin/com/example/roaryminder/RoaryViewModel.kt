package com.example.roaryminder

import com.example.roaryminder.repo.*
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class RoaryViewModel: KMMViewModel() {

    val projectTitle = "Roaryminder"
    private val repo = RoaryRepo()
    private val _roaryRepoInfoList: MutableStateFlow<List<RoaryRepoInfo>> = MutableStateFlow(emptyList())


    @NativeCoroutines
    val roaryRepoInfoList: Flow<List<RoaryRepoInfo>> get() = _roaryRepoInfoList

    init {
        viewModelScope.coroutineScope.launch {
            repo.startSync()
            loadClasses()
        }
    }

    fun saveQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveClass(classForRepo)
        }
    }

    fun deleteQuery(classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.deleteClass(classForRepo._id)
        }
    }

    fun saveAssignment(assignment: Assignments, classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.saveAssignment(assignment, classForRepo)
        }
    }

    fun deleteAssignment(assignment: Assignments, classForRepo: RoaryRepoInfo) {
        viewModelScope.coroutineScope.launch {
            repo.deleteAssignment(assignment, classForRepo)
        }
    }

    fun saveMessage(message: String, assignment: Assignments) {
        viewModelScope.coroutineScope.launch {
            repo.saveMessage(message, assignment)
        }
    }

    private fun loadClasses() {
        viewModelScope.coroutineScope.launch {
            repo.getAllData().collect{
                _roaryRepoInfoList.value = it
            }
        }
    }
}
