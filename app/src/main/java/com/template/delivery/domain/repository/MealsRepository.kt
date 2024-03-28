package com.template.delivery.domain.repository

import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.data.model.CategoryRemote
import com.template.delivery.data.model.MealRemote

interface MealsRepository {
    suspend fun getMeals(): List<MealsDBEntity>
    suspend fun getCategories(): List<MealsCategoriesDBEntity>
    suspend fun getMealsByCategories(listOfCategories: List<String>):List<MealsDBEntity>
}