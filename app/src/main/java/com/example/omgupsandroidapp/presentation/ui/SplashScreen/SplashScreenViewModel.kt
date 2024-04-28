package com.example.omgupsandroidapp.presentation.ui.SplashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.signIn.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _splashScreenState = MutableStateFlow(SplashScreenState())
    val splashScreenState = _splashScreenState.asStateFlow()

    init {
        userIsSignIn()
    }

    private fun userIsSignIn() {
        signInUseCase.isUserSignIn().onEach { isUserSignIn ->
            _splashScreenState.update {
                it.copy(isUserSignIn = isUserSignIn)
            }
        }.launchIn(viewModelScope)
    }
}




