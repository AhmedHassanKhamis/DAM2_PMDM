package com.cursoandroid.retrofitcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cursoandroid.retrofitcomposeapp.viewModel.TelefonosViewModel
import com.cursoandroid.retrofitcomposeapp.views.CalculadoraView
import com.cursoandroid.retrofitcomposeapp.views.DetailView
import com.cursoandroid.retrofitcomposeapp.views.HomeViewAhmed


@Composable
fun NavManager(modifier: Modifier, viewModel: TelefonosViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeViewAhmed(Modifier , viewModel, navController)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType}
        )){
            val id = it.arguments?.getInt("id")?: 0
            DetailView(Modifier, viewModel, navController, id)
        }
        composable("Calculadora") {
            CalculadoraView(navController)
        }
    }
}