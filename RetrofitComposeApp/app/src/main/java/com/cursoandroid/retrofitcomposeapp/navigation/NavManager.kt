package com.cursoandroid.retrofitcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cursoandroid.retrofitcomposeapp.viewModel.GamesViewModel
import com.cursoandroid.retrofitcomposeapp.views.DetailView
import com.cursoandroid.retrofitcomposeapp.views.HomeView
import com.cursoandroid.retrofitcomposeapp.views.SearchGameView

@Composable
fun NavManager(modifier: Modifier, viewModel: GamesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(Modifier , viewModel, navController)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType}
        )){
            val id = it.arguments?.getInt("id")?: 0
            DetailView(Modifier, viewModel, navController, id)
        }
        composable("SearchGameView") {
            SearchGameView(viewModel, navController )
        }
    }
}