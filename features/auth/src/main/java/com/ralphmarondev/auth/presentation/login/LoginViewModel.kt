package com.ralphmarondev.auth.presentation.login

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.application.KeepSafe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val dao = KeepSafe.database.dao()

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    fun onUsernameValueChanged(value: String) {
        _username.value = value
    }

    fun onPasswordValueChanged(value: String) {
        _password.value = value
    }


    fun onLogin(
        onLoginSuccessful: () -> Unit,
        snackbarState: SnackbarHostState
    ) {
        if (_username.value.isEmpty() && _password.value.isEmpty()) {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = "Username and Password cannot be empty!"
                )
            }
            return
        } else if (_username.value.isEmpty() && _password.value.isNotEmpty()) {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = "Username cannot be empty!"
                )
            }
            return
        } else if (_username.value.isNotEmpty() && _password.value.isEmpty()) {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = "Password cannot be empty!"
                )
            }
            return
        }

        viewModelScope.launch {
            if (isUserExists()) {
                onLoginSuccessful()
            } else {
                snackbarState.showSnackbar(
                    message = "Password for '${_username.value}' is incorrect."
                )
            }
        }
    }

    private suspend fun isUserExists(): Boolean {
        return try {
            dao.userExists(
                username = _username.value,
                password = _password.value
            )

        } catch (e: Exception) {
            Log.d("AUTH", "Login Error: ${e.message}")
            false
        }
    }
}