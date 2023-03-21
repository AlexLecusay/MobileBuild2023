package com.example.roaryminder

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
}