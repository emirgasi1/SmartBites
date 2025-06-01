package com.example.smartbites.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reminder",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE)]
)

data class Reminder(
    @PrimaryKey(autoGenerate = true) val reminderId: Int = 0,
    val userId: Int,
    val time: String,
    val message: String
)
