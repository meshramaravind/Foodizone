package com.arvind.foodizone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arvind.foodizone.component.StandardScaffold
import com.arvind.foodizone.navigation.Navigation
import com.arvind.foodizone.navigation.Screen
import com.arvind.foodizone.ui.theme.FoodizoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodizoneTheme {
                // A surface container using the 'background' color from the theme
                FoodiZoneComposeUIMain()
            }
        }
    }

    @Composable
    fun FoodiZoneComposeUIMain() {
        FoodizoneTheme {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()
            ) {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                StandardScaffold(
                    navController = navController,
                    showBottomBar = navBackStackEntry?.destination?.route in listOf(
                        Screen.HomeScreen.route,
                        Screen.FavoriteScreen.route,
                        Screen.OrderScreen.route,
                        Screen.ProfileScreen.route,
                    ),
                    modifier = Modifier.fillMaxSize(),
                    onFabClick = {
                        navController.navigate(Screen.SearchScreen.route)
                    }
                ) {
                    Navigation(navController)
                }
            }

        }
    }
}

