package com.template.delivery.presentation.meals_menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.delivery.data.database.entities.MealsCategoriesDBEntity
import com.template.delivery.data.database.entities.MealsDBEntity
import com.template.delivery.domain.usecase.GetMealsCategoriesUseCase
import com.template.delivery.domain.usecase.GetMealsFilteredByCategories
import com.template.delivery.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsMenuViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase,
    private val getMealsCategoriesUseCase: GetMealsCategoriesUseCase,
    private val getMealsFilteredByCategories: GetMealsFilteredByCategories
) : ViewModel() {
    private val _listOfMeals: MutableStateFlow<List<MealsDBEntity>> = MutableStateFlow(emptyList())
    val listOfMeals = _listOfMeals.asStateFlow()

    private val _listOfMealsCategories: MutableStateFlow<List<MealsCategoriesDBEntity>> =
        MutableStateFlow(
            emptyList()
        )
    val listOfMealsCategories = _listOfMealsCategories.asStateFlow()
    private val _isLoadInProgress: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val isLoadInProgress = _isLoadInProgress.asStateFlow()

    private val _selectedCategoriesToFilterMeals: MutableStateFlow<List<String>> = MutableStateFlow(
        emptyList()
    )
    init {
        fetchMeals()
    }

    fun fetchMeals() {
        viewModelScope.launch {
            _isLoadInProgress.emit(true)
            _listOfMeals.emit(
                getMealsUseCase.execute()
            )
            _listOfMealsCategories.emit(
                getMealsCategoriesUseCase.execute()
            )
            _isLoadInProgress.emit(false)
        }
    }

    fun addCategoryToFilterMeals(category: String) {
        viewModelScope.launch {
            _isLoadInProgress.emit(true)
            _selectedCategoriesToFilterMeals.update {
                it.plus(category)
            }
            _listOfMeals.emit(
                getMealsFilteredByCategories.execute(categories = _selectedCategoriesToFilterMeals.value)
            )
            _isLoadInProgress.emit(false)
        }

    }

    fun removeCategoryToFilterMeals(category: String) {
        viewModelScope.launch{
            _isLoadInProgress.emit(true)
            _selectedCategoriesToFilterMeals.emit(
                _selectedCategoriesToFilterMeals.value.filterNot { mealCategory -> mealCategory == category }
            )
            if(_selectedCategoriesToFilterMeals.value.isEmpty()){
                fetchMeals()
            } else {
                _listOfMeals.emit(
                    getMealsFilteredByCategories.execute(categories = _selectedCategoriesToFilterMeals.value)
                )
            }
            _isLoadInProgress.emit(false)
        }
    }
}