package com.example.omgupsandroidapp.presentation.ui.screens.ServicesScreen.services.OrderScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omgupsandroidapp.domain.use_case.service.order.GetOrderUseCase
import com.omgupsapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val getOrderUseCase: GetOrderUseCase
) : ViewModel() {

    private val _orderState = MutableStateFlow(OrderState())
    val orderState = _orderState.asStateFlow()

    init {
        getOrder()
    }

    private fun getOrder() {
        getOrderUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _orderState.update {
                        it.copy(orderList = result.data ?: emptyList())
                    }
                }

                is Resource.Loading -> {
                    _orderState.update {
                        it.copy(isLoading = true)
                    }
                }

                is Resource.Error -> {
                    _orderState.update {
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