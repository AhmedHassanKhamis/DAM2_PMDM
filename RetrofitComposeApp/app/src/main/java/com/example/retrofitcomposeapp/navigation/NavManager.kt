package com.example.retrofitcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.retrofitcomposeapp.viewmodel.GamesViewModel
import com.example.retrofitcomposeapp.views.DetailView
import com.example.retrofitcomposeapp.views.HomeView

@Composable
fun NavManager(modifier: Modifier,viewModel: GamesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            HomeView(modifier,viewModel, navController)
        }
        composable("DetailView/{id}", arguments= listOf(
            navArgument("id"){
                type= NavType.IntType
            }
        )){
            val id = it.arguments?.getInt("id")?:0
            DetailView(viewModel, navController,id )
        }
    }
}