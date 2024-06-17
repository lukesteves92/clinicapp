package com.inspirecoding.clinicapp.main.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
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
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.inspirecoding.clinicapp.navigation.nav.Navigation
import com.inspirecoding.clinicapp.core.navigation.screen.Screen
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.ds.theme.main.ClinicAppTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val remoteConfigUtils : RemoteConfigUtils by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        remoteConfigUtils.initFirebaseRemoteConfig(activity = this)

        setContent {
            val navController = rememberNavController()
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