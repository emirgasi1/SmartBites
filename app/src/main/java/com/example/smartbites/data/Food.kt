@Entity(tableName = "food")

data class Food(
    @PrimaryKey(autoGenerate = true) val foodId: Int = 0,
    val name: String,
    val caloriesPer100g: Int,
    val proteinPer100g: Int,
    val carbsPer100g: Int,
    val fatPer100g: Int
)
