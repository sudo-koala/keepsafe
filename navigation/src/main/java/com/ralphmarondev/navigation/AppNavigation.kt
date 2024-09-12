package com.ralphmarondev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.auth.AuthScreen
import kotlinx.serialization.Serializable

class Screen {
    @Serializable
    object Auth

    @Serializable
    object Home
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Auth
    ) {
        composable<Screen.Auth> {
            AuthScreen(navController)
        }
        composable<Screen.Home> { }
    }
}