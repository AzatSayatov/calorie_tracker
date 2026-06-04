package com.sayatcode.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayatcode.core.R
import com.sayatcode.core.domain.preferences.Preferences
import com.sayatcode.core.domain.use_case.FilterOutDigits
import com.sayatcode.core.navigation.Route
import com.sayatcode.core.util.UiEvent
import com.sayatcode.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences,
): ViewModel() {
    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String){
        if (weight.length <= 3){
            this.weight = weight
        }
    }

    fun onNextClick(){
        viewModelScope.launch {
            val wieghtNumber = weight.toIntOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.error_weight_cant_be_empty))
                )
                return@launch
            }
            preferences.saveAge(wieghtNumber)
            _uiEvent.send(
                UiEvent.Navigate(Route.ACTIVITY)
            )
        }
    }
}