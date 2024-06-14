package com.inspirecoding.clinicapp.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.inspirecoding.clinicapp.navigation.nav.Navigation
import com.inspirecoding.clinicapp.core.navigation.screen.Screen
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.ds.theme.main.ClinicAppTheme
import org.koin.androidx.compose.inject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val remoteConfigUtils: RemoteConfigUtils by inject()
            val navController = rememberNavController()
            remoteConfigUtils.initFirebaseRemoteConfig(activity = this)
            ClinicAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavigateMain(navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigateMain(navController: NavHostController) {
    Navigation(navController = navController, Screen.Login.route)
}