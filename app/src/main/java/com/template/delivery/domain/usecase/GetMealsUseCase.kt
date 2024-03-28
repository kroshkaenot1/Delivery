package com.template.delivery.domain.usecase

import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.domain.repository.MealsRepository
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val mealsRepository: MealsRepository
) {
    suspend fun execute(): List<MealsDBEntity> =
        mealsRepository.getMeals()

}