package com.example.omgupsandroidapp.presentation.ui.LogoutScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omgupsapp.domain.use_case.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogOutViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
): ViewModel() {

    fun logOut(){
        viewModelScope.launch {
            logoutUseCase.logOut()
        }
    }

}