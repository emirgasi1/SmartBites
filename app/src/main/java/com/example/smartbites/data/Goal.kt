package com.example.smartbites.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "goal",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE)]
)

data class Goal(
    @PrimaryKey(autoGenerate = true) val goalId: Int = 0,
    val userId: Int,
    val dailyCalorieGoal: Int,
    val proteinGoal: Int,
    val carbGoal: Int,
    val fatGoal: Int
)
