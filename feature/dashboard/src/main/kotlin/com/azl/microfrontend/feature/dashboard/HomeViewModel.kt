package com.azl.microfrontend.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azl.microfrontend.core.common.DispatcherProvider
import com.azl.microfrontend.core.common.Result
import com.azl.microfrontend.core.network.ProductService
import com.azl.microfrontend.core.network.model.Product
import com.azl.microfrontend.core.network.model.ProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productService: ProductService,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _productsState = MutableStateFlow<Result<List<Product>>>(Result.Loading)
    val productsState: StateFlow<Result<List<Product>>> = _productsState

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch(dispatcherProvider.io) {
            _productsState.value = Result.Loading
            try {
                val response = productService.getProducts()
                _productsState.value = Result.Success(response.products)
            } catch (e: Exception) {
                _productsState.value = Result.Error(e)
            }
        }
    }
}
