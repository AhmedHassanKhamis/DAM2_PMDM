package com.example.ahmed_hassan_examen_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cursoandroid.retrofitcomposeapp.views.HomeView
import com.cursoandroid.retrofitcomposeapp.views.ResultadosView
import com.cursoandroid.retrofitcomposeapp.views.SalarioView
import com.example.ahmed_hassan_examen_compose.viewModel.SalarioViewModel

@Composable
fun NavManager(modifier: Modifier, viewModel: SalarioViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(Modifier , viewModel, navController)
        }
        composable("SalarioView/{nombre}/{edad}", arguments = listOf(
            navArgument("nombre") { type = NavType.StringType},
            navArgument("edad") { type = NavType.IntType}

        )){
            val edad = it.arguments?.getInt("edad")?: 0
            val nombre = it.arguments?.getString("nombre")?: "Jane Doe"
            SalarioView(Modifier, viewModel, navController, edad, nombre)
        }
        composable("ResultadosView/{nombre}/{edad}/{salario}", arguments = listOf(
            navArgument("nombre") { type = NavType.StringType},
            navArgument("edad") { type = NavType.IntType}
            ,navArgument("salario") { type = NavType.StringType}

        )){
            val edad = it.arguments?.getInt("edad")?: 0
            val nombre = it.arguments?.getString("nombre")?: "Jane Doe"
            val salario = it.arguments?.getString("salario")?: "0"
            ResultadosView(Modifier, viewModel, navController,nombre, edad, salario)
        }
    }
}