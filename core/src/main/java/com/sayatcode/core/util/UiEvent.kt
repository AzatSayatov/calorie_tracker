package com.sayatcode.core.util

sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackbar(var message: UiText): UiEvent()
}