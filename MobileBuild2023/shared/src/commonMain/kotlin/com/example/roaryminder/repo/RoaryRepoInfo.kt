package com.example.roaryminder.repo

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.annotations.PrimaryKey

class RoaryRepoInfo: RealmObject {
    @PrimaryKey
    var _id: RealmUUID = RealmUUID.random()
    var queries: String = ""
}