package com.azl.microfrontend.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azl.microfrontend.core.database.entity.UserSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserSessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: UserSessionEntity)

    @Query("SELECT * FROM user_sessions LIMIT 1")
    fun getSession(): Flow<UserSessionEntity?>

    @Query("DELETE FROM user_sessions")
    suspend fun clearSession()
}
