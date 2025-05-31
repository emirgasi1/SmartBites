@Dao

interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goal: Goal): Long

    @Query("SELECT * FROM goal WHERE userId = :userId")
    fun getGoalsByUser(userId: Int): Flow<List<Goal>>

    @Update
    suspend fun update(goal: Goal)

    @Delete
    suspend fun delete(goal: Goal)
}
