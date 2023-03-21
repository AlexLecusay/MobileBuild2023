package com.example.roaryminder.android

import androidx.lifecycle.ViewModel

class RoaryViewModel(): ViewModel() {
    val projectTitle = "Roaryminder"
    val fakeClasses = listOf(
        FakeClass("COP123", "A computer class"),
        FakeClass("HIS", "A history class"),
        FakeClass("HER", "A her class"),
        FakeClass("Mother", "A mother class"),
        FakeClass("Father", "A father class"),
        FakeClass("Cousin", "A cousin class"),
        )
}