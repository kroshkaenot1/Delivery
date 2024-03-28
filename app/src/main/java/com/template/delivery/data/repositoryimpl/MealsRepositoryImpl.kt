package com.template.delivery.data.repositoryimpl

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.template.delivery.data.database.dao.MealsDAO
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.data.mapper.MealCategoryRemoteToMealCategoryDBEntity
import com.template.delivery.data.mapper.MealRemoteToMealDBEntityMapper
import com.template.delivery.data.remote.api.APIProducts
import com.template.delivery.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val apiProducts: APIProducts,
    private val mealsDAO: MealsDAO,
    private val mealRemoteToMealDBEntityMapper: MealRemoteToMealDBEntityMapper,
    private val mealCategoryRemoteToMealCategoryDBEntity: MealCategoryRemoteToMealCategoryDBEntity
) : MealsRepository {
    override suspend fun getMeals(): List<MealsDBEntity> {
        return when {
            isNetworkAvailable() -> {
                val listOfMeals = apiProducts.getMeals()
                mealsDAO.clearMealsData()
                listOfMeals.mealsRemote.map { meal ->
                    val mealDBEntity = mealRemoteToMealDBEntityMapper.map(mealRemote = meal)
                    mealsDAO.insertNewMealsData(meal = mealDBEntity)
                    mealDBEntity
                }
            }

            !isNetworkAvailable() -> {
                mealsDAO.getMealsData()
            }

            else -> emptyList()
        }
    }

    override suspend fun getCategories(): List<MealsCategoriesDBEntity> {
        return when {
            isNetworkAvailable() -> {
                val listOfCategories = apiProducts.getCategories()
                mealsDAO.clearMealsCategoriesData()
                listOfCategories.categories.map { categoryRemote ->
                    val mealCategoryDBEntity =
                        mealCategoryRemoteToMealCategoryDBEntity.map(mealCategoryRemote = categoryRemote)
                    mealsDAO.insertNewMealsCategoriesData(mealCategory = mealCategoryDBEntity)
                    mealCategoryDBEntity
                }
            }

            !isNetworkAvailable() -> {
                mealsDAO.getMealsCategoriesData()
            }

            else -> emptyList()
        }
    }

    override suspend fun getMealsByCategories(listOfCategories: List<String>): List<MealsDBEntity> =
        mealsDAO.getMealsByCategories(categoryList = listOfCategories)

    private fun isNetworkAvailable(): Boolean {
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }
}