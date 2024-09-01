package com.ralphmarondev.keepsafe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.keepsafe.features.fam_info.FamilyInformation
import com.ralphmarondev.keepsafe.home.HomeScreen
import kotlinx.serialization.Serializable

class Screens {
    @Serializable
    object Home

    @Serializable
    object FamInfo
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home
    ) {
        composable<Screens.Home> {
            HomeScreen(navController)
        }
        composable<Screens.FamInfo> {
            FamilyInformation()
        }
    }
}