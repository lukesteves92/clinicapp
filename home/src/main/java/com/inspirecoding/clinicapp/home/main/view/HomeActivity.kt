package com.inspirecoding.clinicapp.home.main.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.inspirecoding.clinicapp.commons.constants.Constants.PreferencesKeys.BOTTOMITEMS
import com.inspirecoding.clinicapp.commons.constants.Constants.PreferencesKeys.SHARED_NAME
import com.inspirecoding.clinicapp.commons.models.domain.navigation.main.NavigationModelDomain
import com.inspirecoding.clinicapp.core.navigation.screen.Screen
import com.inspirecoding.clinicapp.ds.components.bottomnavigation.MainBottomNavigation
import com.inspirecoding.clinicapp.ds.theme.main.ClinicAppTheme
import com.inspirecoding.clinicapp.home.navigation.navigation.Navigation

@OptIn(ExperimentalCoilApi::class)
class HomeActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSharedPreferences(context = this)
        setContent {
            val navController = rememberNavController()
            ClinicAppTheme {
                Scaffold(
                    bottomBar = {
                        MainBottomNavigation(
                            navController = navController,
                            items = getBottomItems().navigationItems
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(PaddingValues(bottom = it.calculateBottomPadding()))) {
                        NavigateHome(navController = navController)
                    }
                }
            }
        }
    }

    private fun getBottomItems(): NavigationModelDomain {
        val gson = Gson()
        val json = sharedPreferences.getString(BOTTOMITEMS, null)
        val type = object : TypeToken<NavigationModelDomain>() {}.type
        return gson.fromJson(json, type)
    }

    private fun setupSharedPreferences(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigateHome(navController: NavHostController) {
    Navigation(navController = navController, Screen.Home.route)
}