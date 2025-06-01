package com.example.smartbites.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM user WHERE userId = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>
    @Query("SELECT * FROM user WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUserByEmailAndPassword(email: String, password: String): User?

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}
