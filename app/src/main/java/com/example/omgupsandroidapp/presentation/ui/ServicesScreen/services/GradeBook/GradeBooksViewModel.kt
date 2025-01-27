package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.GradeBook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.gradebook.GradeBookUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GradeBooksViewModel @Inject constructor(
    private val getGradeBookUseCase: GradeBookUseCase
) : ViewModel() {

    private val _gradeBookState = MutableStateFlow(GradeBookState())
    val gradeBookState = _gradeBookState.asStateFlow()

    init {
        getGradeBook()
    }

    private fun getGradeBook() {
        getGradeBookUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _gradeBookState.update {
                        it.copy(gradeBookList = result.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _gradeBookState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _gradeBookState.update {
                        it.copy(
                            error = result.message
                                ?: "Ошибка соединения, это может быть вызванно активным VPN сервисом"
                        )
                    }
                }

            }
        }.launchIn(viewModelScope)
    }

}