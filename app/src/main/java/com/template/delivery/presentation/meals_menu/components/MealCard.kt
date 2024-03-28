package com.template.delivery.presentation.meals_menu.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideSubcomposition
import com.bumptech.glide.integration.compose.RequestState
import com.template.delivery.R
import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.presentation.utils.shimmerEffect

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MealCard(
    modifier: Modifier = Modifier,
    meal: MealsDBEntity
) {
    val context = LocalContext.current
    val ingredients = buildString {
        if (meal.strIngredient1 != "") {
            append(meal.strIngredient1)
        }
        if (meal.strIngredient2 != "") {
            append(", ")
            append(meal.strIngredient2)
        }
        if (meal.strIngredient3 != "") {
            append(", ")
            append(meal.strIngredient3)
        }
        if (meal.strIngredient4 != "") {
            append(", ")
            append(meal.strIngredient4)
        }
        if (meal.strIngredient5 != "") {
            append(", ")
            append(meal.strIngredient5)
        }
        if (meal.strIngredient6 != "") {
            append(", ")
            append(meal.strIngredient6)
        }
        if (meal.strIngredient7 != "") {
            append(", ")
            append(meal.strIngredient7)
        }
        if (meal.strIngredient8 != "") {
            append(", ")
            append(meal.strIngredient8)
        }
        if (meal.strIngredient9 != "") {
            append(", ")
            append(meal.strIngredient9)
        }
        if (meal.strIngredient10 != "") {
            append(", ")
            append(meal.strIngredient10)
        }
        if (meal.strIngredient11 != "") {
            append(", ")
            append(meal.strIngredient11)
        }
        if (meal.strIngredient12 != "") {
            append(", ")
            append(meal.strIngredient12)
        }
        if (meal.strIngredient13 != "") {
            append(", ")
            append(meal.strIngredient13)
        }
        if (meal.strIngredient14 != "") {
            append(", ")
            append(meal.strIngredient14)
        }
        if (meal.strIngredient15 != "") {
            append(", ")
            append(meal.strIngredient15)
        }
        if (meal.strIngredient16 != "") {
            append(", ")
            append(meal.strIngredient16)
        }
        if (meal.strIngredient17 != "") {
            append(", ")
            append(meal.strIngredient17)
        }
        if (meal.strIngredient18 != "") {
            append(", ")
            append(meal.strIngredient18)
        }
        if (meal.strIngredient19 != "") {
            append(", ")
            append(meal.strIngredient19)
        }
        if (meal.strIngredient20 != "") {
            append(", ")
            append(meal.strIngredient20)
        }
    }
    Column(modifier = modifier) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color(ContextCompat.getColor(context, R.color.divider_meals))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            GlideSubcomposition(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = meal.strMealThumb
            ) {
                when (state) {
                    RequestState.Failure -> {}
                    RequestState.Loading -> {
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .shimmerEffect()
                                .clip(shape = RoundedCornerShape(10.dp))
                        )
                    }

                    is RequestState.Success -> Image(painter = painter, contentDescription = null)
                }
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = meal.strMeal,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = ingredients)
                Box(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color(
                                    ContextCompat.getColor(
                                        context,
                                        R.color.selected_Nav_Bar_Text
                                    )
                                )
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .align(Alignment.End)
                ) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "от 345 р",
                        color = Color(
                            ContextCompat.getColor(
                                context,
                                R.color.selected_Nav_Bar_Text
                            )
                        )
                    )
                }
            }
        }
    }
}