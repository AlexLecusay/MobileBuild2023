package com.example.roaryminder.repo

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.types.RealmUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class RoaryRepo {

    lateinit var realm: Realm

    private suspend fun setupRealmSync() {
        val user = appServiceInstance.login(Credentials.anonymous())

        val flexibleSyncConfig = SyncConfiguration
            .Builder(
            user = user,
            schema = setOf(RoaryRepoInfo::class, Assignments::class, ChatRepos::class),
        ).initialSubscriptions(
            rerunOnOpen = true
        ) { realm ->
            add(
                query = realm.query<RoaryRepoInfo>(),
                name = "subscription name",
                updateExisting = true
            )
        }.build()
        realm = Realm.open(flexibleSyncConfig)
    }

    private val appServiceInstance by lazy {
        val configuration =
            AppConfiguration.Builder("roaryminders-hlpws").log(LogLevel.ALL).build()
        App.create(configuration)
    }

    suspend fun startSync() {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        //realm.write { deleteAll() }
    }

    suspend fun getAllData(): Flow<List<RoaryRepoInfo>> {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        return realm.query<RoaryRepoInfo>().asFlow().map { it.list }
    }

    suspend fun saveInfo(classForRepo: RoaryRepoInfo) {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        val info = RoaryRepoInfo().apply {
            className = classForRepo.className
            classDescription = classForRepo.classDescription
            classAssignments = classForRepo.classAssignments
        }
        realm.write {
            copyToRealm(info)
        }
    }
}