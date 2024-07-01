package com.inspirecoding.clinicapp.ds.components.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.annotation.ExperimentalCoilApi
import com.inspirecoding.clinicapp.core.navigation.screen.Screen
import com.inspirecoding.clinicapp.commons.models.domain.navigation.items.NavigationItemsModelDomain

@ExperimentalCoilApi
@Composable
fun MainBottomNavigation(
    navController: NavHostController,
    items: List<NavigationItemsModelDomain>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AnimatedVisibility(
        visible = isBottomMenu(currentDestination = currentDestination),
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {

        NavigationBar(
            modifier = Modifier.height(61.dp),
            containerColor = Color.White
        ) {
            items.forEach { item ->
                val selected = currentDestination?.hierarchy?.any { it.route == item.redirectTo } == true
                NavigationBarItem(
                    icon = {
                        val icon = when (item.redirectTo) {
                            Screen.Home.route -> Icons.Filled.Home
                            Screen.Agenda.route -> Icons.Filled.DateRange
                            Screen.Menu.route -> Icons.Filled.Menu
                            else -> Icons.Filled.Home
                        }

                        NavigationIcon(
                            icon = icon,
                            isSelected = selected
                        )
                    },
                    label = {
                        item.name?.let {
                            Text(
                                text = it,
                                fontSize = 9.sp
                            )
                        }
                    },
                    selected = selected,
                    onClick = {
                        item.redirectTo?.let {
                            navController.navigate(it) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationIcon(
    icon: ImageVector,
    isSelected: Boolean
) {
    val iconColor = if (isSelected) Color(0xFF138DC2) else Color.Gray

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = iconColor
    )
}

private fun isBottomMenu(currentDestination: NavDestination?): Boolean {
    return when (currentDestination?.route) {
        Screen.Home.route,
        Screen.Agenda.route,
        Screen.Menu.route -> {
            true
        }
        else -> false
    }
}