package com.template.delivery.data.mapper
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.model.CategoryRemote

class MealCategoryRemoteToMealCategoryDBEntity {
    fun map(mealCategoryRemote: CategoryRemote): MealsCategoriesDBEntity {
        return MealsCategoriesDBEntity(
            idCategory = mealCategoryRemote.idCategory,
            strCategory = mealCategoryRemote.strCategory,
            strCategoryThumb = mealCategoryRemote.strCategoryThumb,
            strCategoryDescription = mealCategoryRemote.strCategoryDescription
        )
    }
}