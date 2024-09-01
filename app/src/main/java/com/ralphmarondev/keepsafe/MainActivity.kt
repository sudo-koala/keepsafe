package com.ralphmarondev.keepsafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.keepsafe.home.HomeScreen
import com.ralphmarondev.keepsafe.ui.theme.KeepsafeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeepsafeTheme {
                HomeScreen()
            }
        }
    }
}