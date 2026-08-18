package com.azl.microfrontend.feature.preauth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azl.microfrontend.core.common.DispatcherProvider
import com.azl.microfrontend.core.common.Result
import com.azl.microfrontend.core.database.dao.UserSessionDao
import com.azl.microfrontend.core.database.entity.UserSessionEntity
import com.azl.microfrontend.core.network.AuthService
import com.azl.microfrontend.core.network.model.LoginRequest
import com.azl.microfrontend.core.network.model.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService,
    private val userSessionDao: UserSessionDao,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<LoginResponse>?>(null)
    val loginState: StateFlow<Result<LoginResponse>?> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch(dispatcherProvider.io) {
            _loginState.value = Result.Loading
            try {
                val response = authService.login(LoginRequest(username, password))
                
                // Save session to database
                userSessionDao.insertSession(
                    UserSessionEntity(
                        id = response.id,
                        username = response.username,
                        email = response.email,
                        firstName = response.firstName,
                        lastName = response.lastName,
                        gender = response.gender,
                        image = response.image,
                        accessToken = response.accessToken,
                        refreshToken = response.refreshToken
                    )
                )
                
                _loginState.value = Result.Success(response)
            } catch (e: Exception) {
                _loginState.value = Result.Error(e)
            }
        }
    }
    
    fun resetState() {
        _loginState.value = null
    }
}
