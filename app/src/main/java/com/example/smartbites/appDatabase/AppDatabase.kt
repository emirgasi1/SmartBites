package com.example.smartbites.appDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smartbites.data.Food
import com.example.smartbites.data.Goal
import com.example.smartbites.data.Meal
import com.example.smartbites.data.MealItem
import com.example.smartbites.data.Reminder
import com.example.smartbites.data.User
import android.content.Context
import androidx.room.Room
import com.example.smartbites.data.FoodDao
import com.example.smartbites.data.GoalDao
import com.example.smartbites.data.MealDao
import com.example.smartbites.data.MealItemDao
import com.example.smartbites.data.ReminderDao
import com.example.smartbites.data.UserDao

@Database(
    entities = [User::class, Goal::class, Food::class, Meal::class, MealItem::class, Reminder::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun goalDao(): GoalDao
    abstract fun foodDao(): FoodDao
    abstract fun mealDao(): MealDao
    abstract fun mealItemDao(): MealItemDao
    abstract fun reminderDao(): ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smartbites_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}