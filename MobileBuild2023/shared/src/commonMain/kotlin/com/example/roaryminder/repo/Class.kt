package com.example.roaryminder.repo

import io.realm.kotlin.types.RealmList

data class Class(val className: String, val classDescription: String, val classAssignments: RealmList<Assignments>)
