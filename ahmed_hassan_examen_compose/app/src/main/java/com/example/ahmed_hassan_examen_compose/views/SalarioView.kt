package com.cursoandroid.retrofitcomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahmed_hassan_examen_compose.components.MainButton
import com.example.ahmed_hassan_examen_compose.components.MainTextField
import com.example.ahmed_hassan_examen_compose.components.MainTopBar
import com.example.ahmed_hassan_examen_compose.components.SpaceH
import com.example.ahmed_hassan_examen_compose.viewModel.SalarioViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalarioView(
    modifier: Modifier = Modifier,
    viewModel: SalarioViewModel,
    navController: NavController,
    edad: Int,
    nombre: String
) {

//    // Llamamos al método clean() cuando clicamos en el botón de regresar
//    DisposableEffect(Unit) {
//        onDispose {
//            viewModel.clean()
//        }
//    }

    Scaffold(
        topBar = {
            MainTopBar(title = "Datos Salario", showBackButton = true, onClickBackButton = {
                navController.popBackStack()
            }) { }
        }
    ) {
        ContentSalarioView(modifier, it, viewModel, navController, nombre, edad)
    }

}


@Composable
fun ContentSalarioView(modifier: Modifier ,pad: PaddingValues, viewModel: SalarioViewModel, navController: NavController, nombre: String, edad: Int) {
    Column(modifier = Modifier
        .padding(pad)
        .fillMaxSize()
        .background(Color(0xFF625b71)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (edad < 16) {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    colors = CardDefaults.cardColors(Color(0xFF2B2626))

                ) {
                    Text(text = "No puedes trabajar en la empresa siendo menor de edad", modifier = Modifier.padding(30.dp), color = Color.LightGray)
                }
            }
        } else {
            var salario by remember { mutableStateOf("") }
            var tipoContrato by remember { mutableStateOf("") }
            Text(text = "Calcular Salario neto para $nombre", fontSize = 20.sp, color = Color.White)
            SpaceH()
            SpaceH()
            Text(text = "Introduce tu salario bruto:", color = Color.LightGray)
            MainTextField(
                value = salario,
                miOnValueChange = { salario = it },
                label = "Salario bruto"
            )
            SpaceH()
            MainButton(miTexto = "Limpiar", color = Color.White) {
                salario = ""
            }
            SpaceH()
            MainButton(miTexto = viewModel.tipoContrato ?: "Trabajo Fijo", color = Color.White) {
                if (viewModel.tipoContrato == "Trabajo Fijo") {
                    viewModel.tipoContrato = "Trabajo Temporal"
                } else {
                    viewModel.tipoContrato = "Trabajo Fijo"
                }
            }
            SpaceH()
            if (salario == "") {
                MainButton(miTexto = "Calcular Salario Neto", habilitado = false, color = Color.White){}
            } else {
                MainButton(miTexto = "Calcular Salario Neto", color = Color.White) {
                    viewModel.salario = salario
                    navController.navigate("ResultadosView/$nombre/$edad/$salario")
                }
            }

        }
    }

}