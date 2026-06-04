package com.sayatcode.onboarding_presentation.actyvity_level

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sayatcode.core.domain.model.ActivityLevel
import com.sayatcode.core.domain.model.Gender
import com.sayatcode.core.domain.preferences.Preferences
import com.sayatcode.core.navigation.Route
import com.sayatcode.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel(){

    var activityLevel by mutableStateOf<ActivityLevel>(ActivityLevel.Medium)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onActivityLevelClick(level: ActivityLevel){
        activityLevel = level
    }

    fun onNextClick(){
        viewModelScope.launch {
            preferences.saveActivityLevel(activityLevel = activityLevel)
            _uiEvent.send(UiEvent.Navigate(Route.GOAL))
        }
    }
}