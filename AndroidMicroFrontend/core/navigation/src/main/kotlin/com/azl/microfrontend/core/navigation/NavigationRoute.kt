package com.azl.microfrontend.core.navigation

sealed class NavigationRoute(val route: String) {
    data object PreAuth : NavigationRoute("preauth_graph") {
        const val login = "login"
        const val signup = "signup"
        const val forgotPassword = "forgot_password"
    }
    data object Onboarding : NavigationRoute("onboarding")
    data object Dashboard : NavigationRoute("dashboard")
    data object Profile : NavigationRoute("profile")
}
