package com.sayatcode.onboarding_presentation.nutrient_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayatcode.core.domain.preferences.Preferences
import com.sayatcode.core.domain.use_case.FilterOutDigits
import com.sayatcode.core.navigation.Route
import com.sayatcode.core.util.UiEvent
import com.sayatcode.core.util.UiText
import com.sayatcode.onboarding_domain.use_case.ValidateNutrientGoals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
    private val nutrientGoals: ValidateNutrientGoals
): ViewModel() {
    var state by mutableStateOf(NutrientGoalState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onEvent(event: NutrientGoalEvent){
        when(event){
            is NutrientGoalEvent.OnCarbsRatioEntered -> {
                state = state.copy(carbsRatio = filterOutDigits(event.ratio))
            }
            is NutrientGoalEvent.OnProteinRatioEntered -> {
                state = state.copy(proteinRatio = filterOutDigits(event.ratio))
            }
            is NutrientGoalEvent.OnFatRatioEntered -> {
                state = state.copy(fatRatio = filterOutDigits(event.ratio))
            }
            is NutrientGoalEvent.OnNextClick -> {
                val result = nutrientGoals(
                    carbsRatioText = state.carbsRatio,
                    proteinRationText = state.proteinRatio,
                    fatRatioText = state.fatRatio
                )
                when(result){
                    is ValidateNutrientGoals.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(
                                UiEvent.ShowSnackbar(result.message)
                            )
                        }
                    }
                    is ValidateNutrientGoals.Result.Success -> {
                        preferences.saveCarbRatio(result.carbsRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        viewModelScope.launch {
                            _uiEvent.send(
                                UiEvent.Navigate(Route.TRACKER_OVERVIEW)
                            )
                        }
                    }
                }
            }
        }
    }
}