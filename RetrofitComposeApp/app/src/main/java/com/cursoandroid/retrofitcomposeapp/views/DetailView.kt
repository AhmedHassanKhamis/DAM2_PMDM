package com.cursoandroid.retrofitcomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cursoandroid.retrofitcomposeapp.components.MainImage
import com.cursoandroid.retrofitcomposeapp.components.MainTopBar
import com.cursoandroid.retrofitcomposeapp.components.MetaWebSite
import com.cursoandroid.retrofitcomposeapp.components.ReviewCard
import com.cursoandroid.retrofitcomposeapp.util.Constantes.Companion.COLOR_CUSTOM
import com.cursoandroid.retrofitcomposeapp.util.Constantes.Companion.MI_TEXTO
import com.cursoandroid.retrofitcomposeapp.viewModel.GamesViewModel
import kotlin.concurrent.timerTask

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(modifier: Modifier = Modifier, viewModel: GamesViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        viewModel.getSingleCharacterById(id)
    }

    // Llamamos al método clean() cuando clicamos en el botón de regresar
    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }


    Scaffold(
        topBar = {
//            MainTopBar(title = viewModel.state.name, showBackButton = true,) {
//                navController.popBackStack()
//            }
            MainTopBar(title = viewModel.state.name, showBackButton = true, onClickBackButton = {
                navController.popBackStack() }) { }
        }
    ) {

        ContentDetailView(it, viewModel)
    }

}

   // Text(text= id.toString(), color = Color.White)


@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: GamesViewModel) {
    val state = viewModel.state

    Column (modifier = Modifier
        .padding(pad)
        .background(Color(COLOR_CUSTOM))
    ){
        MainImage(image=state.image)
        Spacer(Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=20.dp, end=5.dp)
        ){
            MetaWebSite(url = "https://www.metacritic.com/tv/rick-morty/")
            ReviewCard(state.id)
        }


        val scroll = rememberScrollState(0)
        Text(
            text = MI_TEXTO,
            color = Color.White,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 15.dp, end=15.dp, bottom = 10.dp)
                .verticalScroll(scroll)
        )
    }
}