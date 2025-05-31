@Dao

interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: Food): Long

    @Query("SELECT * FROM food")
    fun getAllFood(): Flow<List<Food>>

    @Update
    suspend fun update(food: Food)

    @Delete
    suspend fun delete(food: Food)
}
