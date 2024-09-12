package com.ralphmarondev.home.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Features(
    val icon: ImageVector,
    val text: String,
    val onClick: () -> Unit
)