package com.example.roaryminder.repo

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration

class RoaryRepo {

    lateinit var realm: Realm

    private suspend fun setupRealmSync() {
        val user = appServiceInstance.login(Credentials.anonymous())
        val config = SyncConfiguration
            .Builder(user, setOf(RoaryRepoInfo::class))
            .initialSubscriptions { realm ->
                // information about the data that can be read or modified.
                add(
                    query = realm.query<RoaryRepoInfo>(),
                    name = "subscription name",
                    updateExisting = true
                )
            }
            .build()
        realm = Realm.open(config)
    }

    private val appServiceInstance by lazy {
        val configuration =
            AppConfiguration.Builder("roaryminders-hlpws").log(LogLevel.ALL).build()
        App.create(configuration)
    }

    suspend fun getAllData(): List<String> {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        val queryResult = realm.query<RoaryRepoInfo>().find()
        return queryResult.map { it.queries }
    }

    suspend fun saveInfo(query: String) {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        val info = RoaryRepoInfo().apply {
            queries = query
        }
        realm.write {
            copyToRealm(info)
        }
    }
}