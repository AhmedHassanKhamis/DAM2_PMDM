package com.example.retrofitcomposeapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.retrofitcomposeapp.components.CardGame
import com.example.retrofitcomposeapp.components.MainTopBar
import com.example.retrofitcomposeapp.viewmodel.GamesViewModel

@Composable
fun HomeView(modifier: Modifier = Modifier,  viewModel: GamesViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "RICK AND MORTY", showBackButton = true) {}
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }

}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad: PaddingValues, navController: NavController){
    val personajes by viewModel.personajes.collectAsState()

    LazyColumn(modifier = Modifier
        .padding(pad)
        .background(Color(0xFF640D0D))
    ) {

        items(personajes) {
                item->
            CardGame(persona = item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(
                text=item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(10.dp)

            )
        }
    }
}