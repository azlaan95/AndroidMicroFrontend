package com.azl.microfrontend.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.azl.microfrontend.core.database.dao.UserSessionDao
import com.azl.microfrontend.core.database.entity.UserSessionEntity

@Database(entities = [UserSessionEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userSessionDao(): UserSessionDao
}
