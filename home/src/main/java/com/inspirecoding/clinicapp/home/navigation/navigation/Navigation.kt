package com.inspirecoding.clinicapp.home.navigation.navigation

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.inspirecoding.clinicapp.core.navigation.screen.Screen
import com.inspirecoding.clinicapp.home.features.agenda.view.AgendaScreen
import com.inspirecoding.clinicapp.home.features.home.view.HomeScreen
import com.inspirecoding.clinicapp.home.features.menu.view.MenuScreen
import com.inspirecoding.clinicapp.home.navigation.manager.NavigationCommand
import com.inspirecoding.clinicapp.home.navigation.manager.HomeNavigationManager
import com.inspirecoding.clinicapp.home.navigation.manager.NavigationType
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.inject

@ExperimentalPagerApi
@Composable
fun Navigation(navController: NavHostController, startDestination: String) {
    ObserveNavigation(navController = navController)

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Agenda.route) {
            AgendaScreen()
        }
        composable(Screen.Menu.route) {
            MenuScreen()
        }
    }
}

@Composable
fun ObserveNavigation(navController: NavHostController) {
    val navManager: HomeNavigationManager by inject()
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    LaunchedEffect(Unit) {
        navManager.navigationEvent.collectLatest { navigationEvent ->
            when (navigationEvent) {
                is NavigationCommand.Navigate -> {
                    when (navigationEvent.type) {
                        NavigationType.NavigateTo -> {
                            navController.navigate(
                                route = navigationEvent.destination,
                                navOptions = navigationEvent.navOptions
                            )
                        }
                        is NavigationType.PopUpTo -> {
                            if (navigationEvent.type.savedStateHandle != null) {
                                val (key, value) = navigationEvent.type.savedStateHandle
                                navController.previousBackStackEntry
                                    ?.savedStateHandle
                                    ?.set(key, value)
                            }
                            navController.popBackStack(
                                route = navigationEvent.destination,
                                inclusive = navigationEvent.type.inclusive
                            )
                        }
                    }
                }
                is NavigationCommand.NavigateUp -> navController.navigateUp()
                is NavigationCommand.PopStackBack -> navController.popBackStack()
                is NavigationCommand.OnBackPressed -> dispatcher?.onBackPressed()
            }
        }
    }
}