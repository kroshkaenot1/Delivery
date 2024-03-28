package com.template.delivery.data.remote.api

import com.template.delivery.data.model.ListOfCategoriesRemote
import com.template.delivery.data.model.ListOfMealsRemote
import retrofit2.http.GET

interface APIProducts {
    @GET("search.php?s")
    suspend fun getMeals(): ListOfMealsRemote

    @GET("categories.php")
    suspend fun getCategories(): ListOfCategoriesRemote
}