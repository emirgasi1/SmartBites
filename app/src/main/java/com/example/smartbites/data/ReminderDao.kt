package com.example.smartbites.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface ReminderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reminder: Reminder): Long

    @Query("SELECT * FROM reminder WHERE userId = :userId")
    fun getRemindersByUser(userId: Int): Flow<List<Reminder>>

    @Delete
    suspend fun delete(reminder: Reminder)
}
