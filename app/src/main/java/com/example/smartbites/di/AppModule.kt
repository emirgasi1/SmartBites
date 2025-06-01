package com.example.smartbites.di

import android.content.Context
import androidx.room.Room
import com.example.smartbites.appDatabase.AppDatabase
import com.example.smartbites.data.FoodDao
import com.example.smartbites.data.GoalDao
import com.example.smartbites.data.MealDao
import com.example.smartbites.data.MealItemDao
import com.example.smartbites.data.UserDao
import com.example.smartbites.repository.FoodRepository
import com.example.smartbites.repository.FoodRepositoryImpl
import com.example.smartbites.repository.GoalRepository
import com.example.smartbites.repository.GoalRepositoryImpl
import com.example.smartbites.repository.MealItemRepository
import com.example.smartbites.repository.MealItemRepositoryImpl
import com.example.smartbites.repository.MealRepository
import com.example.smartbites.repository.MealRepositoryImpl
import com.example.smartbites.repository.UserRepository
import com.example.smartbites.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "smartbites_db"
        ).build()
    }

    @Provides
    fun provideMealDao(db: AppDatabase): MealDao = db.mealDao()
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()
    @Provides
    fun provideGoalDao(db: AppDatabase) = db.goalDao()
    @Provides
    fun provideFoodDao(db: AppDatabase) = db.foodDao()
    @Provides
    fun provideMealItemDao(db: AppDatabase) = db.mealItemDao()
    @Provides
    fun provideReminderDao(db: AppDatabase) = db.reminderDao()

    @Provides
    @Singleton
    fun provideMealRepository(mealDao: MealDao): MealRepository {
        return MealRepositoryImpl(mealDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository =
        UserRepositoryImpl(userDao)

    @Provides
    @Singleton
    fun provideGoalRepository(goalDao: GoalDao): GoalRepository =
        GoalRepositoryImpl(goalDao)

    @Provides
    @Singleton
    fun provideFoodRepository(foodDao: FoodDao): FoodRepository =
        FoodRepositoryImpl(foodDao)

    @Provides
    @Singleton
    fun provideMealItemRepository(mealItemDao: MealItemDao): MealItemRepository =
        MealItemRepositoryImpl(mealItemDao)


}
