package com.azl.microfrontend.feature.preauth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.azl.microfrontend.core.navigation.MicroApp
import com.azl.microfrontend.core.navigation.NavigationRoute
import javax.inject.Inject

class PreAuthMicroAppImpl @Inject constructor() : MicroApp {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: androidx.compose.ui.Modifier
    ) {
        navGraphBuilder.navigation(
            startDestination = NavigationRoute.PreAuth.login,
            route = NavigationRoute.PreAuth.route
        ) {
            composable(NavigationRoute.PreAuth.login) {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(NavigationRoute.Dashboard.route) {
                            popUpTo(NavigationRoute.PreAuth.route) { inclusive = true }
                        }
                    },
                    onSignupClick = {
                        navController.navigate(NavigationRoute.PreAuth.signup)
                    },
                    onForgotPasswordClick = {
                        navController.navigate(NavigationRoute.PreAuth.forgotPassword)
                    }
                )
            }
            composable(NavigationRoute.PreAuth.signup) {
                SignupScreen(
                    onSignupComplete = {
                        navController.popBackStack()
                    },
                    onBackToLogin = {
                        navController.popBackStack()
                    }
                )
            }
            composable(NavigationRoute.PreAuth.forgotPassword) {
                ForgotPasswordScreen(
                    onResetPasswordClick = {
                        navController.popBackStack()
                    },
                    onBackToLogin = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
