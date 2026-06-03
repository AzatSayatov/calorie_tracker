package com.sayatcode.calorietracker.navigation

import androidx.navigation.NavController
import com.sayatcode.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}