package com.template.delivery.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.database.entities.MealsDBEntity

@Dao
interface MealsDAO {
    @Query("DELETE FROM meals")
    suspend fun clearMealsData()

    @Query("DELETE FROM meals_categories")
    suspend fun clearMealsCategoriesData()

    @Insert(entity = MealsDBEntity::class)
    suspend fun insertNewMealsData(meal: MealsDBEntity)

    @Insert(entity = MealsCategoriesDBEntity::class)
    suspend fun insertNewMealsCategoriesData(mealCategory: MealsCategoriesDBEntity)

    @Query("SELECT * FROM meals")
    suspend fun getMealsData(): List<MealsDBEntity>

    @Query("SELECT * FROM meals_categories")
    suspend fun getMealsCategoriesData(): List<MealsCategoriesDBEntity>

    @Query("SELECT * FROM meals WHERE strCategory IN (:categoryList)")
    suspend fun getMealsByCategories(categoryList: List<String>): List<MealsDBEntity>
}