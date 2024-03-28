package com.template.delivery.di

import com.template.delivery.data.mapper.MealCategoryRemoteToMealCategoryDBEntity
import com.template.delivery.data.mapper.MealRemoteToMealDBEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Singleton
    @Provides
    fun provideMealsRemoteToDatabaseEntityMapperToMealsRepositoryImpl() =
        MealRemoteToMealDBEntityMapper()
    @Singleton
    @Provides
    fun provideMealsCategoriesRemoteToDatabaseEntityMapperToMealsCRepositoryImpl() =
        MealCategoryRemoteToMealCategoryDBEntity()
}