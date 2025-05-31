@Dao

interface ReminderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reminder: Reminder): Long

    @Query("SELECT * FROM reminder WHERE userId = :userId")
    fun getRemindersByUser(userId: Int): Flow<List<Reminder>>

    @Delete
    suspend fun delete(reminder: Reminder)
}
