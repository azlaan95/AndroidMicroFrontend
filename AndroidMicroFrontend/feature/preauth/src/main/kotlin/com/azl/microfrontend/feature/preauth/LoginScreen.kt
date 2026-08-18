package com.azl.microfrontend.feature.preauth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.azl.microfrontend.core.common.Result
import com.azl.microfrontend.core.designsystem.ArtisticBackground
import com.azl.microfrontend.core.designsystem.ArtisticTextField
import com.azl.microfrontend.core.designsystem.PrimaryButton

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignupClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    val loginState by viewModel.loginState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(loginState) {
        if (loginState is Result.Success) {
            onLoginSuccess()
            viewModel.resetState()
        } else if (loginState is Result.Error) {
            snackbarHostState.showSnackbar((loginState as Result.Error).exception.message ?: "Login Failed")
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        ArtisticBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome Back",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Login with your username",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp
                )
                
                Spacer(modifier = Modifier.height(48.dp))

                ArtisticTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = "Username",
                    isError = false
                )

                Spacer(modifier = Modifier.height(16.dp))

                ArtisticTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password",
                    isError = false,
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    TextButton(onClick = onForgotPasswordClick) {
                        Text(text = "Forgot Password?", color = Color(0xFFE94560))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                if (loginState is Result.Loading) {
                    CircularProgressIndicator(color = Color(0xFFE94560))
                } else {
                    PrimaryButton(
                        text = "Login",
                        onClick = {
                            if (username.isNotEmpty() && password.isNotEmpty()) {
                                viewModel.login(username, password)
                            }
                        },
                        modifier = Modifier.fillMaxWidth().height(56.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Don't have an account?", color = Color.White.copy(alpha = 0.7f))
                    TextButton(onClick = onSignupClick) {
                        Text(text = "Sign Up", color = Color(0xFFE94560), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
