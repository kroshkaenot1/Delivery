package com.template.delivery.presentation.meals_menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.template.delivery.R
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity

@Composable
fun FiltersBar(
    modifier: Modifier = Modifier,
    listOfCategories: List<MealsCategoriesDBEntity>,
    onFilterSelected: (String) -> Unit,
    onFilterUnselected: (String) -> Unit
) {
    val context = LocalContext.current
    LazyRow(
        modifier = modifier
            .background(Color.White)
    ) {
        items(listOfCategories) { mealCategory ->
            val isSelected = remember {
                mutableStateOf(false)
            }
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .shadow(
                        elevation = if (!isSelected.value) 3.dp else 0.dp,
                        clip = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        if (isSelected.value) Color(
                            ContextCompat.getColor(
                                context,
                                R.color.filter_box_selected
                            )
                        ).copy(alpha = 0.2f) else Color.White
                    )
                    .pointerInput(Unit) {
                        var startPos = Offset.Zero
                        var movedFarEnough = false
                        awaitPointerEventScope {
                            while (true) {
                                val event = awaitPointerEvent()
                                when (event.type) {
                                    PointerEventType.Press -> {
                                        startPos = event.changes.first().position
                                        movedFarEnough = false
                                    }

                                    PointerEventType.Move -> {
                                        if (!movedFarEnough) {
                                            val currentPosition = event.changes.last().position
                                            val distanceX =
                                                kotlin.math.abs(currentPosition.x - startPos.x)
                                            val distanceY =
                                                kotlin.math.abs(currentPosition.y - startPos.y)
                                            movedFarEnough =
                                                distanceX.coerceAtLeast(distanceY) > 20.dp.toPx()
                                        }
                                    }

                                    PointerEventType.Release -> {
                                        if (event.changes.first().position == event.changes.last().position &&
                                            !movedFarEnough
                                        ) {
                                            if (!isSelected.value) {
                                                onFilterSelected(mealCategory.strCategory)
                                            } else {
                                                onFilterUnselected(mealCategory.strCategory)
                                            }
                                            isSelected.value = !isSelected.value
                                        }
                                    }

                                    else -> {}
                                }
                            }
                        }
                    }
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    ),
                    text = mealCategory.strCategory,
                    color = Color(
                        ContextCompat.getColor(
                            context,
                            if (isSelected.value) R.color.filter_box_selected else R.color.filter_text_not_selected
                        )
                    )
                )
            }
        }
    }
}