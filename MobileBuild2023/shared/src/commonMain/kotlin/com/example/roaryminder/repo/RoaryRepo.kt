package com.example.roaryminder.repo

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.types.RealmUUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoaryRepo {

    lateinit var realm: Realm

    private val appServiceInstance by lazy {
        val configuration =
            AppConfiguration.Builder("roaryminders-hlpws").log(LogLevel.ALL).build()
        App.create(configuration)
    }

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

    suspend fun startSync() {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
    }

    suspend fun clearDatabase() {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        realm.write { deleteAll() }
    }

    suspend fun getAllData(): Flow<List<RoaryRepoInfo>> {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        return realm.query<RoaryRepoInfo>().asFlow().map { it.list }
    }

    suspend fun updateClass(id: RealmUUID, classForRepo: RoaryRepoInfo) {
        realm.write {
            try {
                val classToUpdate = realm.query<RoaryRepoInfo>(query = "_id == $0", id)
                    .first()
                    .find()
                if (classToUpdate != null) {
                    classToUpdate.className = classForRepo.className
                    classToUpdate.classDescription = classForRepo.classDescription
                    classToUpdate.classAssignments = classForRepo.classAssignments
                }
            } catch (e: Exception) {
                print("Error updating class: $e")
            }
        }
    }

    suspend fun saveClass(classForRepo: RoaryRepoInfo) {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        val classInfo = RoaryRepoInfo().apply {
            className = classForRepo.className
            classDescription = classForRepo.classDescription
            classAssignments = classForRepo.classAssignments
        }
        realm.write {
            val doesClassExist: RoaryRepoInfo? = this.query<RoaryRepoInfo>("className = $0", classForRepo.className)
                    ?.find()
                    ?.firstOrNull()
            doesClassExist?.let {
                print("Class already exists")
            } ?: copyToRealm(classInfo)
        }
    }

    suspend fun deleteClass(id: RealmUUID) {
        realm.write {
            try {
                val classToDelete: RoaryRepoInfo = this.query<RoaryRepoInfo>("_id = $0", id)
                    .find()
                    .first()
                delete(classToDelete)
            } catch (e: Exception) {
                print("Error deleting class: $e")
            }
        }
    }
}