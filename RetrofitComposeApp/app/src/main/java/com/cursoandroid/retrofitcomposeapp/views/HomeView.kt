package com.cursoandroid.retrofitcomposeapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.cursoandroid.retrofitcomposeapp.components.CardGame
import com.cursoandroid.retrofitcomposeapp.components.MainTopBar
import com.cursoandroid.retrofitcomposeapp.viewModel.GamesViewModel


@Composable
fun HomeView(modifier: Modifier = Modifier, viewModel: GamesViewModel, navController: NavController) {
    Scaffold(
        topBar = {
          //  MainTopBar(title = "API GAMES", showBackButton = true, ) { }
            MainTopBar(title = "API GAMES", onClickBackButton = {} ) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel, it, navController )
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel,pad: PaddingValues, navController: NavController) {

    //val games by viewModel.games.collectAsState()
    val personajes by viewModel.personajes.collectAsState()

    LazyColumn(modifier = Modifier
        .padding(pad)
        .background(Color(0XFF640D0D))

    ) {
        items(personajes) {
                item->
            CardGame(personaje = item) {
                // enviar a la siguiente vista el id
                navController.navigate("DetailView/${item.id}")
            }
            Text(text=item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
                )
        }
    }
}
