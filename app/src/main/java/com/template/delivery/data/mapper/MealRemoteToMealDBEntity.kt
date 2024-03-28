package com.template.delivery.data.mapper

import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.data.model.MealRemote

class MealRemoteToMealDBEntityMapper {

    fun map(mealRemote: MealRemote): MealsDBEntity {
        return MealsDBEntity(
            idMeal = mealRemote.idMeal,
            strMeal = mealRemote.strMeal,
            strDrinkAlternate = mealRemote.strDrinkAlternate,
            strCategory = mealRemote.strCategory,
            strArea = mealRemote.strArea,
            strInstructions = mealRemote.strInstructions,
            strMealThumb = mealRemote.strMealThumb,
            strTags = mealRemote.strTags,
            strYoutube = mealRemote.strYoutube,
            strIngredient1 = mealRemote.strIngredient1,
            strIngredient2 = mealRemote.strIngredient2,
            strIngredient3 = mealRemote.strIngredient3,
            strIngredient4 = mealRemote.strIngredient4,
            strIngredient5 = mealRemote.strIngredient5,
            strIngredient6 = mealRemote.strIngredient6,
            strIngredient7 = mealRemote.strIngredient7,
            strIngredient8 = mealRemote.strIngredient8,
            strIngredient9 = mealRemote.strIngredient9,
            strIngredient10 = mealRemote.strIngredient10,
            strIngredient11 = mealRemote.strIngredient11,
            strIngredient12 = mealRemote.strIngredient12,
            strIngredient13 = mealRemote.strIngredient13,
            strIngredient14 = mealRemote.strIngredient14,
            strIngredient15 = mealRemote.strIngredient15,
            strIngredient16 = mealRemote.strIngredient16,
            strIngredient17 = mealRemote.strIngredient17,
            strIngredient18 = mealRemote.strIngredient18,
            strIngredient19 = mealRemote.strIngredient19,
            strIngredient20 = mealRemote.strIngredient20,
            strMeasure1 = mealRemote.strMeasure1,
            strMeasure2 = mealRemote.strMeasure2,
            strMeasure3 = mealRemote.strMeasure3,
            strMeasure4 = mealRemote.strMeasure4,
            strMeasure5 = mealRemote.strMeasure5,
            strMeasure6 = mealRemote.strMeasure6,
            strMeasure7 = mealRemote.strMeasure7,
            strMeasure8 = mealRemote.strMeasure8,
            strMeasure9 = mealRemote.strMeasure9,
            strMeasure10 = mealRemote.strMeasure10,
            strMeasure11 = mealRemote.strMeasure11,
            strMeasure12 = mealRemote.strMeasure12,
            strMeasure13 = mealRemote.strMeasure13,
            strMeasure14 = mealRemote.strMeasure14,
            strMeasure15 = mealRemote.strMeasure15,
            strMeasure16 = mealRemote.strMeasure16,
            strMeasure17 = mealRemote.strMeasure17,
            strMeasure18 = mealRemote.strMeasure18,
            strMeasure19 = mealRemote.strMeasure19,
            strMeasure20 = mealRemote.strMeasure20,
            strSource = mealRemote.strSource,
            strImageSource = mealRemote.strImageSource,
            strCreativeCommonsConfirmed = mealRemote.strCreativeCommonsConfirmed,
            dateModified = mealRemote.dateModified
        )
    }
}
