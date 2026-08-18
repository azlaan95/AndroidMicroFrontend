package com.azl.microfrontend.feature.dashboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.azl.microfrontend.core.navigation.MicroApp
import com.azl.microfrontend.core.navigation.NavigationRoute
import javax.inject.Inject

class DashboardMicroAppImpl @Inject constructor() : MicroApp {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: androidx.compose.ui.Modifier
    ) {
        navGraphBuilder.composable(NavigationRoute.Dashboard.route) {
            DashboardScreen()
        }
    }
}
