package com.example.roaryminder.repo

import io.realm.kotlin.types.RealmList

data class ChatRepo(val messages: RealmList<String>)
