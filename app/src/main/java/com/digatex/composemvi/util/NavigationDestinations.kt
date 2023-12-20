package com.digatex.composemvi.util

sealed class NavigationDestination(val destination: String) {
    object MainScreen : NavigationDestination("MainScreen")
}