package com.omgupsapp.presentation.ui.SettingsScreen

import androidx.lifecycle.ViewModel
import com.example.omgupsandroidapp.presentation.ui.SettingsScreen.ThemeState
import com.omgupsapp.domain.use_case.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {
    private val _themeState = MutableStateFlow(ThemeState())
    val themeState = _themeState.asStateFlow()
    fun logout() {
        logoutUseCase()
    }

    fun themeUpdate(themeState: Boolean) = !themeState
}
