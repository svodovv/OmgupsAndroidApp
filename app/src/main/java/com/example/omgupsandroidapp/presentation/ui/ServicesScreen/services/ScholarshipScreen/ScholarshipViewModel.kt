package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ScholarshipScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.GetScholarshipUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ScholarshipViewModel @Inject constructor(
    private val scholarshipUseCase: GetScholarshipUseCase
) : ViewModel() {
    private val _scholarship = MutableStateFlow(ScholarshipState())
    val scholarship = _scholarship.asStateFlow()


    init {
        getScholarship()
    }

    private fun getScholarship() {
        scholarshipUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _scholarship.update {
                        it.copy(
                            scholarshipList = result.data ?: emptyList()
                        )
                    }
                }

                is Resource.Loading -> {
                    _scholarship.update {
                        it.copy(
                            loading = true
                        )
                    }
                }

                is Resource.Error -> {
                    _scholarship.update {
                        it.copy(
                            error = it.error
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}