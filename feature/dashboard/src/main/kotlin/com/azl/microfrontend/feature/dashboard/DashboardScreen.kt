package com.azl.microfrontend.feature.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

sealed class DashboardTab(val route: String, val title: String, val icon: ImageVector) {
    data object Home : DashboardTab("home", "Home", Icons.Default.Home)
    data object Category : DashboardTab("category", "Category", Icons.Default.List)
    data object Cart : DashboardTab("cart", "Cart", Icons.Default.ShoppingCart)
    data object Account : DashboardTab("account", "Account", Icons.Default.AccountCircle)
}

@Composable
fun DashboardScreen() {
    var selectedTab by remember { mutableStateOf<DashboardTab>(DashboardTab.Home) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF1A1A2E),
                contentColor = Color.White
            ) {
                val tabs = listOf(
                    DashboardTab.Home,
                    DashboardTab.Category,
                    DashboardTab.Cart,
                    DashboardTab.Account
                )
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFFE94560),
                            selectedTextColor = Color(0xFFE94560),
                            unselectedIconColor = Color.White.copy(alpha = 0.6f),
                            unselectedTextColor = Color.White.copy(alpha = 0.6f),
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (selectedTab) {
                DashboardTab.Home -> HomeScreen()
                DashboardTab.Category -> CategoryScreen()
                DashboardTab.Cart -> CartScreen()
                DashboardTab.Account -> AccountScreen()
            }
        }
    }
}

@Composable
fun CategoryScreen() {
    Text(text = "Category Screen")
}

@Composable
fun CartScreen() {
    Text(text = "Cart Screen")
}

@Composable
fun AccountScreen(viewModel: AccountViewModel = hiltViewModel()) {
    val session by viewModel.userSession.collectAsState(initial = null)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A2E))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        session?.let {
            Text(text = "Hello, ${it.firstName} ${it.lastName}!", color = Color.White, fontSize = 20.sp)
            Text(text = "Email: ${it.email}", color = Color.White.copy(alpha = 0.6f))
        } ?: Text(text = "No Session Found", color = Color.White)
    }
}
