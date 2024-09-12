package com.ralphmarondev.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> get() = _selectedTab

    fun onSelectedTabIndexChange(value: Int) {
        _selectedTab.value = value
    }
}