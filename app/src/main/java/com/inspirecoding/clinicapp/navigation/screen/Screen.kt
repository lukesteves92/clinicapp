package com.inspirecoding.clinicapp.navigation.screen

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
}