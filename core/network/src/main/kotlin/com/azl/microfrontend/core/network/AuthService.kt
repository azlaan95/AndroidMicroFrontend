package com.azl.microfrontend.core.network

import com.azl.microfrontend.core.network.model.LoginRequest
import com.azl.microfrontend.core.network.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
