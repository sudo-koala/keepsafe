package com.ralphmarondev.keepsafe.home.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Feature(
    val icon: ImageVector,
    val text: String,
    val onClick: () -> Unit
)