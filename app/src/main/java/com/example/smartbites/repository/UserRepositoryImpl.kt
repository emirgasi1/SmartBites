package com.example.smartbites.repository

import com.example.smartbites.data.User
import com.example.smartbites.data.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun insertUser(user: User): Long = userDao.insert(user)
    override suspend fun getUserById(id: Int): User? = userDao.getUserById(id)
    override fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    override suspend fun updateUser(user: User) = userDao.update(user)
    override suspend fun deleteUser(user: User) = userDao.delete(user)
    override suspend fun getUserByEmailAndPassword(email: String, password: String): User? =
        userDao.getUserByEmailAndPassword(email, password)
}
