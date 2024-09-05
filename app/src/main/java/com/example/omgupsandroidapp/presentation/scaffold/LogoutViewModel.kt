package com.example.omgupsandroidapp.presentation.scaffold

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omgupsapp.domain.use_case.logout.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogoutViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
) :ViewModel() {
    fun logout(){
        viewModelScope.launch(Dispatchers.IO) {
            logoutUseCase()
        }
    }
}