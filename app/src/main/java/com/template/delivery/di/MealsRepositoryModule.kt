package com.template.delivery.di

import com.template.delivery.data.repositoryimpl.MealsRepositoryImpl
import com.template.delivery.domain.repository.MealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MealsRepositoryModule {
    @Binds
    abstract fun bindMealsRepositoryToMealsRepositoryImpl(impl: MealsRepositoryImpl):
            MealsRepository
}
