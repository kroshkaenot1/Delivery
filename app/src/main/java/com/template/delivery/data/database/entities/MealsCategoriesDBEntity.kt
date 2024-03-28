package com.template.delivery.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "meals_categories",indices = [Index("id")])
data class MealsCategoriesDBEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "idCategory")
    val idCategory: String,
    @ColumnInfo(name = "strCategory")
    val strCategory: String,
    @ColumnInfo(name = "strCategoryThumb")
    val strCategoryThumb: String,
    @ColumnInfo(name = "strCategoryDescription")
    val strCategoryDescription: String
)

