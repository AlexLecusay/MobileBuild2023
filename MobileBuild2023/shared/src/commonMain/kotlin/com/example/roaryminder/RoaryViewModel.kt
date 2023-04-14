package com.example.roaryminder

import com.example.roaryminder.repo.*
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
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

    fun loadClasses() {
        viewModelScope.coroutineScope.launch {
            repo.getAllData().collect{
                _roaryRepoInfoList.value = it
            }
        }
    }
}
