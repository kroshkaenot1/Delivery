package com.template.delivery.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.template.delivery.data.database.dao.MealsDAO
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.database.entities.MealsDBEntity

@Database(
    version = 1,
    entities = [MealsDBEntity::class,MealsCategoriesDBEntity::class]
)
abstract class MealsDatabase : RoomDatabase() {
    abstract fun getMealsDao(): MealsDAO

    companion object {
        private var database: MealsDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MealsDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context = context,
                    MealsDatabase::class.java,
                    name = "Delivery.db"
                ).build()
                database as MealsDatabase
            } else {
                database as MealsDatabase
            }
        }
    }
}