package com.example.smartbites.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val weight: Float,
    val height: Float,
    val goalType: String
)
