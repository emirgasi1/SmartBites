@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(meal: Meal): Long

    @Query("SELECT * FROM meal WHERE userId = :userId")
    fun getMealsByUser(userId: Int): Flow<List<Meal>>

    @Update
    suspend fun update(meal: Meal)

    @Delete
    suspend fun delete(meal: Meal)
}
