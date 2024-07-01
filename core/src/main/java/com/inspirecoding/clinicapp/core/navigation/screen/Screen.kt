package com.inspirecoding.clinicapp.core.navigation.screen

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
    data object Home : Screen(route = "home")
    data object Agenda : Screen(route = "agenda")
    data object Menu : Screen(route = "menu")
}