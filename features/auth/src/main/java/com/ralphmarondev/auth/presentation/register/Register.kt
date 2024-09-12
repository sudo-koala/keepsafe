package com.ralphmarondev.auth.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ralphmarondev.auth.components.PasswordTextField
import com.ralphmarondev.auth.components.UsernameTextField
import com.ralphmarondev.auth.presentation.register.components.FullNameTextField

@Composable
fun Register(
    onRegistrationSuccessful: () -> Unit,
    snackbarState: SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = viewModel()
) {
    val fullName by viewModel.fullName.collectAsState()
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()

    Column(modifier = modifier) {
        FullNameTextField(
            value = fullName,
            onValueChanged = { viewModel.onFullNameValueChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        )

        UsernameTextField(
            value = username,
            onValueChanged = { viewModel.onUsernameValueChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        )
        PasswordTextField(
            value = password,
            onValueChanged = { viewModel.onPasswordValueChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                viewModel.onRegister(
                    onRegistrationSuccessful = onRegistrationSuccessful,
                    snackbarState = snackbarState
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Text(
                text = "REGISTER",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}