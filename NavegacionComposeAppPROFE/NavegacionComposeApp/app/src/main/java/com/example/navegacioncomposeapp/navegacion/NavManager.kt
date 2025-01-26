package com.example.navegacioncomposeapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.navegacioncomposeapp.views.DetailView
import com.example.navegacioncomposeapp.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "Home"){
        composable("Home") {
            HomeView(navController)
        }
        composable("Detail") {
            DetailView(navController)
        }
    }
}