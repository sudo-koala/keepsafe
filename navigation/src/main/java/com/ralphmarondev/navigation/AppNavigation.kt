package com.ralphmarondev.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.auth.AuthScreen
import com.ralphmarondev.familyinfo.FamilyInfoScreen
import com.ralphmarondev.home.HomeScreen
import kotlinx.serialization.Serializable

class Screen {
    @Serializable
    object Auth

    @Serializable
    object Home

    @Serializable
    object FamilyInfo
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Auth> {
            AuthScreen(
                onLoginSuccessful = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home)
                }
            )
        }
        composable<Screen.Home> {
            HomeScreen(
                onFamilyInfo = {
                    navController.navigate(Screen.FamilyInfo)
                },
                onFamilyPhotos = {}
            )
        }
        composable<Screen.FamilyInfo> {
            FamilyInfoScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}