package com.example.roaryminder

import com.example.roaryminder.repo.Assignment
import com.example.roaryminder.repo.ChatRepo
import com.example.roaryminder.repo.Class
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.stateIn
import kotlinx.coroutines.flow.SharingStarted

open class RoaryViewModel: KMMViewModel() {
    val projectTitle = "Roaryminder"
    val fakeClasses = listOf(
        FakeClass("COP123", "A computer class"),
        FakeClass("HIS", "A history class"),
        FakeClass("HER", "A her class"),
        FakeClass("Mother", "A mother class"),
        FakeClass("Father", "A father class"),
        FakeClass("Cousin", "A cousin class")
    )
    
    //Example
    var allClasses = Class(
        "COP1234",
        "This is a class",
        mutableListOf(
            Assignment(
            "Homework 2",
            "This is the second homework",
            ChatRepo(mutableListOf("Message one", "Message two"))
            )
        )
    )
}