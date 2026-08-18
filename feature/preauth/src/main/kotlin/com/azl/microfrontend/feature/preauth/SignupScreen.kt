package com.azl.microfrontend.feature.preauth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azl.microfrontend.core.common.ValidationUtils
import com.azl.microfrontend.core.designsystem.ArtisticBackground
import com.azl.microfrontend.core.designsystem.ArtisticTextField
import com.azl.microfrontend.core.designsystem.PrimaryButton

@Composable
fun SignupScreen(
    onSignupComplete: () -> Unit,
    onBackToLogin: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    ArtisticBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Account",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Join our community today",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 16.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            ArtisticTextField(
                value = name,
                onValueChange = { name = it },
                label = "Full Name"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ArtisticTextField(
                value = email,
                onValueChange = { 
                    email = it
                    emailError = if (ValidationUtils.isValidEmail(it)) null else "Invalid email"
                },
                label = "Email",
                isError = emailError != null,
                supportingText = emailError
            )

            Spacer(modifier = Modifier.height(16.dp))

            ArtisticTextField(
                value = password,
                onValueChange = { 
                    password = it
                    passwordError = if (ValidationUtils.isValidPassword(it)) null else "Password too short"
                },
                label = "Password",
                isError = passwordError != null,
                supportingText = passwordError,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            ArtisticTextField(
                value = confirmPassword,
                onValueChange = { 
                    confirmPassword = it
                    confirmPasswordError = if (it == password) null else "Passwords do not match"
                },
                label = "Confirm Password",
                isError = confirmPasswordError != null,
                supportingText = confirmPasswordError,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Sign Up",
                onClick = {
                    val isEmailValid = ValidationUtils.isValidEmail(email)
                    val isPasswordValid = ValidationUtils.isValidPassword(password)
                    val isConfirmValid = confirmPassword == password
                    
                    if (isEmailValid && isPasswordValid && isConfirmValid) {
                        onSignupComplete()
                    } else {
                        if (!isEmailValid) emailError = "Invalid email"
                        if (!isPasswordValid) passwordError = "Password too short"
                        if (!isConfirmValid) confirmPasswordError = "Passwords do not match"
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Already have an account?", color = Color.White.copy(alpha = 0.7f))
                TextButton(onClick = onBackToLogin) {
                    Text(text = "Login", color = Color(0xFFE94560), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
