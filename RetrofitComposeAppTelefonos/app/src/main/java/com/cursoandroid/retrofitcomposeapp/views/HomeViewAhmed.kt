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
import com.cursoandroid.retrofitcomposeapp.components.CardTelefono
import com.cursoandroid.retrofitcomposeapp.components.MainTopBarAhmed
import com.cursoandroid.retrofitcomposeapp.viewModel.TelefonosViewModel


@Composable
fun HomeViewAhmed(modifier: Modifier = Modifier, viewModel: TelefonosViewModel, navController: NavController) {
    Scaffold(
        topBar = {
          //  MainTopBar(title = "API GAMES", showBackButton = true, ) { }
            MainTopBarAhmed(title = "API TELEFONOS", onClickBackButton = {} ) {
                navController.navigate("Calculadora")
            }
        }
    ) {
        ContentHomeViewAhmed(viewModel, it, navController )
    }
}

@Composable
fun ContentHomeViewAhmed(viewModel: TelefonosViewModel,pad: PaddingValues, navController: NavController) {

    //val games by viewModel.games.collectAsState()
    val telefonos by viewModel.telefonos.collectAsState()

    LazyColumn(modifier = Modifier
        .padding(pad)
        .background(Color(0XFF640D0D))

    ) {
        items(telefonos) {
                item->
            CardTelefono(item) {
                navController.navigate("DetailView/${item.id}")
            }
        }
    }
}
