


= FILE: AppDatabase.kt ===
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
