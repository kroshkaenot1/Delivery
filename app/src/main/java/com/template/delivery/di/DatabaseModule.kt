package com.template.delivery.di

import android.content.Context
import com.template.delivery.data.database.MealsDatabase
import com.template.delivery.data.database.dao.MealsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDao(@ApplicationContext context: Context) : MealsDAO =
        MealsDatabase.getInstance(context = context).getMealsDao()
}