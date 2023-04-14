package com.example.roaryminder.repo

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.annotations.PrimaryKey

class RoaryRepoInfo: RealmObject {
    @PrimaryKey
    var _id: RealmUUID = RealmUUID.random()
    var className: String = ""
    var classDescription: String = ""
    //var classAssignments: RealmList<Assignments>? = null
    var classAssignments: RealmList<Assignments> = realmListOf()
}

class Assignments: EmbeddedRealmObject {
    var assignmentName: String = ""
    var assignmentDescription: String = ""
    var chatRepo: ChatRepos? = null
}

class ChatRepos: EmbeddedRealmObject {
    var messages: RealmList<String> = realmListOf()
}

