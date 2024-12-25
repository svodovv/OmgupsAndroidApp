package com.example.omgupsandroidapp.presentation.ui.userProfileScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.model.user.UserPhotoUrlModel
import com.example.omgupsandroidapp.domain.use_case.user.GetUserPhotoUseCase
import com.example.omgupsandroidapp.domain.use_case.user.GetUserProfileUseCase
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
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val getUserPhotoUseCase: GetUserPhotoUseCase
) : ViewModel() {
    private val _userProfileState = MutableStateFlow(UserProfileState())
    val userProfileState = _userProfileState.asStateFlow()
    private val _userPhotoState = MutableStateFlow(UserPhotoState())
    val userPhotoState = _userPhotoState.asStateFlow()

    init {
        getUserProfile()
        getUserPhoto()
    }

    fun getUserProfile() {
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

    fun getUserPhoto() {
        getUserPhotoUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _userPhotoState.update {
                        it.copy(
                           userPhoto = result.data ?: UserPhotoUrlModel("", 200)
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