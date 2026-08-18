package com.azl.microfrontend.feature.preauth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azl.microfrontend.core.common.ValidationUtils
import com.azl.microfrontend.core.designsystem.ArtisticBackground
import com.azl.microfrontend.core.designsystem.ArtisticTextField
import com.azl.microfrontend.core.designsystem.PrimaryButton

@Composable
fun ForgotPasswordScreen(
    onResetPasswordClick: () -> Unit,
    onBackToLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }

    ArtisticBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Reset Password",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Enter your email to receive a link",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 16.sp
            )
            
            Spacer(modifier = Modifier.height(48.dp))

            ArtisticTextField(
                value = email,
                onValueChange = { 
                    email = it
                    emailError = if (ValidationUtils.isValidEmail(it)) null else "Invalid email"
                },
                label = "Email Address",
                isError = emailError != null,
                supportingText = emailError
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Send Reset Link",
                onClick = {
                    if (ValidationUtils.isValidEmail(email)) {
                        onResetPasswordClick()
                    } else {
                        emailError = "Invalid email"
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onBackToLogin) {
                Text(text = "Back to Login", color = Color(0xFFE94560), fontWeight = FontWeight.Bold)
            }
        }
    }
}
