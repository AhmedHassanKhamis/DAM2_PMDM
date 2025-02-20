package com.cursoandroid.retrofitcomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahmed_hassan_examen_compose.components.MainButton
import com.example.ahmed_hassan_examen_compose.components.MainTopBar
import com.example.ahmed_hassan_examen_compose.components.SpaceH
import com.example.ahmed_hassan_examen_compose.viewModel.SalarioViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultadosView(modifier: Modifier = Modifier, viewModel: SalarioViewModel, navController: NavController,nombre: String, edad: Int, salario: String) {

    // Llamamos al método clean() cuando clicamos en el botón de regresar
//    DisposableEffect(Unit) {
//        onDispose {
//            viewModel.clean()
//        }
//    }


    Scaffold(
        topBar = {
            MainTopBar(title = "Resultados", showBackButton = true, onClickBackButton = {
                navController.popBackStack() }) { }
        }
    ) {

        ContentResultadosView(it, viewModel,nombre,edad,salario)
    }

}

@Composable
fun ContentResultadosView(pad: PaddingValues, viewModel: SalarioViewModel, nombre: String, edad: Int, salario: String) {
    viewModel.calcularSalario()
    var verDetalles by remember { mutableStateOf("no") }
    Column(modifier = Modifier
        .padding(pad)
        .fillMaxSize()
        .background(Color(0xFF625b71)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Salario neto para $nombre", fontSize = 20.sp, color = Color.White)
        SpaceH()
        Text(text = viewModel.salarioNeto, fontSize = 20.sp, color = Color.Green)
        SpaceH()
        MainButton(miTexto = "Ver detalles", color = Color.LightGray) {
            if (verDetalles == "no") {
                verDetalles = "si"
            } else {
                verDetalles = "no"
            }
        }
        if (verDetalles == "si") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                colors = CardDefaults.cardColors(Color(0xFF2B2626))

            ){
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(text = "Detalles", fontSize = 30.sp, color = Color.LightGray)
                    }
                    Column(modifier = Modifier
                        .padding(10.dp)
                    ) {
                        Text(text = "Nombre: $nombre", fontSize = 15.sp, color = Color.White)
                        Text(text = "Edad: $edad", fontSize = 15.sp, color = Color.White)
                        Text(text = "Salario bruto: $salario", fontSize = 15.sp, color = Color.White)
                        Text(text = "Salario neto: ${viewModel.salarioNeto}", fontSize = 15.sp, color = Color.White)
                        Text(text = "Tipo de contrato: ${viewModel.tipoContrato}", fontSize = 15.sp, color = Color.White)
                        Text(text = "Contingencias comunes: ${viewModel.contingenciasComunes2}", fontSize = 15.sp, color = Color.White)
                        Text(text = "Desempleo: ${viewModel.desempleo2}", fontSize = 15.sp, color = Color.White)
                        Text(text = "IRPF: ${viewModel.irpf2}", fontSize = 15.sp, color = Color.White)
                        Text(text = "Formación profesional: ${viewModel.formacionProfesional2}", fontSize = 15.sp, color = Color.White)
                    }
                }
            }
        }
    }
}