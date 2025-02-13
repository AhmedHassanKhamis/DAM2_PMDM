package com.example.retrofitcomposeapp.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.retrofitcomposeapp.viewmodel.GamesViewModel

@Composable
fun DetailView(viewModel: GamesViewModel,navController: NavController, id: Int){
   Text(text = id.toString(), color = Color.White)
}