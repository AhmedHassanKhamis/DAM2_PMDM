package com.cursoandroid.retrofitcomposeapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ahmed_hassan_examen_compose.components.MainButton
import com.example.ahmed_hassan_examen_compose.components.MainTextField
import com.example.ahmed_hassan_examen_compose.components.MainTopBar
import com.example.ahmed_hassan_examen_compose.components.SpaceH
import com.example.ahmed_hassan_examen_compose.viewModel.SalarioViewModel


@Composable
fun HomeView(modifier: Modifier = Modifier, viewModel: SalarioViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "Calcular salario neto", onClickBackButton = {} ) {
            }
        }
    ) {
        ContentHomeView(viewModel, it, navController )
    }
}

@Composable
fun ContentHomeView(viewModel: SalarioViewModel,pad: PaddingValues, navController: NavController) {

  Column(
      modifier = Modifier
          .padding(pad)
          .fillMaxSize()
          .background(Color(0xFF625b71)),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
  ) {
      var nombre by remember { mutableStateOf("") }
      Text(text = "Introduce tu nombre:", color = Color.White)
      MainTextField(value =nombre , miOnValueChange = {nombre = it}, label = "Nombre")
      SpaceH()
      var edad by remember { mutableStateOf("") }
      Text(text = "Introduce tu edad:", color = Color.White)
      MainTextField(value =edad , miOnValueChange = {edad = it}, label = "Edad")
      SpaceH()
      if (nombre == ""){
          MainButton(miTexto = "Continuar",habilitado = false, color = Color.White) {}
      }else {
          MainButton(miTexto = "Continuar", color = Color.White) {
//          viewModel.clean()
              navController.navigate("SalarioView/$nombre/$edad")
          }
      }
  }

}
