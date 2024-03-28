package com.template.delivery.presentation.meals_menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.template.delivery.presentation.components.BottomAppBar
import com.template.delivery.presentation.meals_menu.components.BannersBar
import com.template.delivery.presentation.meals_menu.components.FiltersBar
import com.template.delivery.presentation.meals_menu.components.MealCard
import com.template.delivery.presentation.meals_menu.components.TopMealsBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MealsMenu(
    modifier: Modifier = Modifier,
    mealsMenuViewModel: MealsMenuViewModel = hiltViewModel()
) {
    val listOfMeals = mealsMenuViewModel.listOfMeals.collectAsState()
    val listOfMealsCategories = mealsMenuViewModel.listOfMealsCategories.collectAsState()
    val isLoadInProgress = mealsMenuViewModel.isLoadInProgress.collectAsState()

    Scaffold(
        topBar = { TopMealsBar(modifier = modifier.padding(top = 20.dp, bottom = 20.dp)) },
        bottomBar = { BottomAppBar() }
    ) { paddingValues ->
        when (isLoadInProgress.value && listOfMealsCategories.value.isEmpty()) {
            true -> {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues = paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = modifier.size(50.dp))
                }
            }

            false -> {
                LazyColumn(modifier = modifier.padding(paddingValues = paddingValues)) {
                    item {
                        BannersBar(modifier = modifier.padding(top = 10.dp))
                    }
                    stickyHeader {
                        FiltersBar(
                            modifier = modifier
                                .padding(start = 20.dp)
                                .height(50.dp),
                            listOfCategories = listOfMealsCategories.value,
                            onFilterSelected = { mealsMenuViewModel.addCategoryToFilterMeals(it) },
                            onFilterUnselected = { mealsMenuViewModel.removeCategoryToFilterMeals(it) }
                        )
                    }
                    if (isLoadInProgress.value) {
                        item {
                            Box(
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(paddingValues = paddingValues),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(modifier = modifier.size(50.dp))
                            }
                        }
                    } else {
                        items(listOfMeals.value) { meal ->
                            MealCard(modifier = modifier.padding(20.dp), meal = meal)
                        }
                    }
                }
            }
        }
    }
}