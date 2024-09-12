package com.ralphmarondev.auth.presentation.register

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.application.KeepSafe
import com.ralphmarondev.model.user.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val dao = KeepSafe.database.dao()

    private val _fullName = MutableStateFlow("")
    val fullName: StateFlow<String> get() = _fullName

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    fun onFullNameValueChanged(value: String) {
        _fullName.value = value
    }

    fun onUsernameValueChanged(value: String) {
        _username.value = value
    }

    fun onPasswordValueChanged(value: String) {
        _password.value = value
    }


    private val _response = MutableStateFlow("")
    fun onRegister(
        onRegistrationSuccessful: () -> Unit,
        snackbarState: SnackbarHostState
    ) {
        if (isFieldEmpty()) {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = _response.value
                )
            }
            return
        }

        if (isRegistrationSuccessful()) {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = "${_fullName.value} is registered successfully!"
                )
            }
            onRegistrationSuccessful()
        } else {
            viewModelScope.launch {
                snackbarState.showSnackbar(
                    message = _response.value
                )
            }
        }
    }

    private fun isRegistrationSuccessful(): Boolean {
        try {
            val user = User(
                fullName = _fullName.value,
                username = _username.value,
                password = _password.value
            )
            viewModelScope.launch {
                dao.createNewUser(user)
            }
            return true
        } catch (ex: Exception) {
            _response.value = "Registration Failed: ${ex.message}"
            Log.d("AUTH", _response.value)
        }
        return false
    }

    private fun isFieldEmpty(): Boolean {
        if (_fullName.value.isEmpty() && _username.value.isEmpty() && _password.value.isEmpty()) {
            _response.value = "Please fill in all fields!"
            return true
        }
        // 1 blank
        else if (_fullName.value.isEmpty() && _username.value.isNotEmpty() && _password.value.isNotEmpty()) {
            _response.value = "Full Name cannot be empty!"
            return true
        } else if (_fullName.value.isNotEmpty() && _username.value.isEmpty() && _password.value.isNotEmpty()) {
            _response.value = "Username cannot be empty!"
            return true
        } else if (_fullName.value.isNotEmpty() && _username.value.isNotEmpty() && _password.value.isEmpty()) {
            _response.value = "Password cannot be empty!"
            return true
        }
        // 2 blanks
        else if (_fullName.value.isEmpty() && _username.value.isEmpty() && _password.value.isNotEmpty()) {
            _response.value = "Full Name and username cannot be empty!"
            return true
        } else if (_fullName.value.isEmpty() && _username.value.isNotEmpty() && _password.value.isEmpty()) {
            _response.value = "Full Name and password cannot be empty!"
            return true
        } else if (_fullName.value.isNotEmpty() && _username.value.isEmpty() && _password.value.isEmpty()) {
            _response.value = "Username password cannot be empty!"
            return true
        }
        return false
    }
}