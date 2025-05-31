@Entity(
    tableName = "meal_item",
    primaryKeys = ["mealId", "foodId"],
    foreignKeys = [
        ForeignKey(entity = Meal::class, parentColumns = ["mealId"], childColumns = ["mealId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Food::class, parentColumns = ["foodId"], childColumns = ["foodId"], onDelete = ForeignKey.CASCADE)
    ]
)

data class MealItem(
    val mealId: Int,
    val foodId: Int,
    val quantity: Int
)
