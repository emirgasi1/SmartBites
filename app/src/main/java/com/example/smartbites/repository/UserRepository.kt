package com.example.smartbites.repository

import com.example.smartbites.data.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User): Long
    suspend fun getUserById(id: Int): User?
    fun getAllUsers(): Flow<List<User>>
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUserByEmailAndPassword(email: String, password: String): User?

}

