package com.example.smartbites.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "meal",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE)]
)

data class Meal(
    @PrimaryKey(autoGenerate = true) val mealId: Int = 0,
    val userId: Int,
    val mealTime: String,
    val mealType: String,
    val totalCalories: Int
)
