package com.ralphmarondev.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.PhotoLibrary
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ralphmarondev.home.components.FeatureCard
import com.ralphmarondev.home.model.Features
import com.ralphmarondev.theme.KeepSafeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onFamilyInfo: () -> Unit,
    onFamilyPhotos: () -> Unit
) {

    val features = listOf(
        Features(
            icon = Icons.Outlined.Info,
            text = "Family Information",
            onClick = onFamilyInfo
        ),
        Features(
            icon = Icons.Outlined.PhotoLibrary,
            text = "Family Photos",
            onClick = onFamilyPhotos
        )
    )

    KeepSafeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Home",
                            fontFamily = FontFamily.Monospace,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.MenuOpen,
                                contentDescription = ""
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Outlined.LightMode,
                                contentDescription = ""
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(4.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(features.size) { index ->
                    FeatureCard(
                        feature = features[index],
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
