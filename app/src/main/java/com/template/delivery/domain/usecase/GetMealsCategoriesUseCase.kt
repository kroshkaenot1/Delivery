package com.template.delivery.domain.usecase

import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.domain.repository.MealsRepository
import javax.inject.Inject

class GetMealsCategoriesUseCase @Inject constructor(
    private val mealsRepository: MealsRepository
) {
    suspend fun execute(): List<MealsCategoriesDBEntity> =
        mealsRepository.getCategories()

}