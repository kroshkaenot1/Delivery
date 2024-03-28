package com.template.delivery.data.model

import com.google.gson.annotations.SerializedName

data class ListOfCategoriesRemote(
    @SerializedName(value = "categories")
    val categories: List<CategoryRemote>
)
data class CategoryRemote(
    @SerializedName(value = "idCategory")
    val idCategory: String,
    @SerializedName(value = "strCategory")
    val strCategory: String,
    @SerializedName(value = "strCategoryThumb")
    val strCategoryThumb: String,
    @SerializedName(value = "strCategoryDescription")
    val strCategoryDescription: String,
)
