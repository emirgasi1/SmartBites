@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM user WHERE userId = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}
