package com.example.omgupsandroidapp.presentation.ui.userProfileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.userProfile.GetUserProfileUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModel() {
    private val _userProfileState = MutableStateFlow(UserProfileState())
    val userProfileState = _userProfileState.asStateFlow()

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        getUserProfileUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _userProfileState.update {
                        it.copy(
                            userProfile = result.data
                        )
                    }
                }

                is Resource.Loading -> {
                    _userProfileState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                is Resource.Error -> {
                    _userProfileState.update {
                        it.copy(
                            error = it.error
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}