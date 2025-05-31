@Dao

interface MealItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mealItem: MealItem)

    @Query("SELECT * FROM meal_item WHERE mealId = :mealId")
    fun getMealItems(mealId: Int): Flow<List<MealItem>>

    @Delete
    suspend fun delete(mealItem: MealItem)
}
