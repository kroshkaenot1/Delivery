package com.template.delivery.domain.usecase

import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.domain.repository.MealsRepository
import javax.inject.Inject

class GetMealsFilteredByCategories @Inject constructor(
    private val mealsRepository: MealsRepository
) {
    suspend fun execute(categories: List<String>): List<MealsDBEntity> =
        mealsRepository.getMealsByCategories(listOfCategories = categories)

}