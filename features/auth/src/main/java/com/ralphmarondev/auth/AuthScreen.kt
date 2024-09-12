package com.ralphmarondev.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ralphmarondev.auth.presentation.login.Login
import com.ralphmarondev.auth.presentation.register.Register
import com.ralphmarondev.theme.KeepSafeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    onLoginSuccessful: () -> Unit
) {
    val viewModel = AuthViewModel()
    val selectedTab by viewModel.selectedTab.collectAsState()

    val snackbarState = remember { SnackbarHostState() }

    KeepSafeTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Authentication",
                            fontFamily = FontFamily.Monospace
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
            snackbarHost = { SnackbarHost(snackbarState) }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .defaultMinSize(minHeight = 200.dp)
                        ) {
                            val listOfTabs = listOf(
                                "LOGIN",
                                "REGISTER"
                            )

                            TabRow(
                                selectedTabIndex = selectedTab,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 4.dp)
                            ) {
                                listOfTabs.forEachIndexed { index, text ->
                                    Tab(
                                        selected = selectedTab == index,
                                        onClick = {
                                            viewModel.onSelectedTabIndexChange(index)
                                        }
                                    ) {
                                        Text(
                                            text = text,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W500,
                                            fontSize = 18.sp,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier
                                                .padding(8.dp),
                                        )
                                    }
                                }
                            }

                            when (selectedTab) {
                                0 -> Login(
                                    onLoginSuccessful = onLoginSuccessful,
                                    snackbarState = snackbarState,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp)
                                )

                                1 -> Register(
                                    onRegistrationSuccessful = {
                                        viewModel.onSelectedTabIndexChange(
                                            0
                                        )
                                    },
                                    snackbarState = snackbarState,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}