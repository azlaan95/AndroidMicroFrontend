package com.azl.microfrontend.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface MicroApp {
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    )
}
