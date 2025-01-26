package com.example.descuentoejercicioapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.descuentoejercicioapp.components.Alert
import com.example.descuentoejercicioapp.components.MainButton
import com.example.descuentoejercicioapp.components.MainTextField
import com.example.descuentoejercicioapp.components.SpaceH
import com.example.descuentoejercicioapp.components.TwoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App descuento", color = Color.White)},
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }){
        ContentHomeView(it)
    }
}


@Composable
fun ContentHomeView(paddingValues: PaddingValues){
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0)}
        var totalDescuento by remember { mutableStateOf( 0.0)}
        var mostrarAlerta by remember { mutableStateOf(false) }
        TwoCard(
            titulo1 ="Total",
            numero1= totalDescuento,
            titulo2 = "Descuento",
            numero2 =precioDescuento
        )
        MainTextField(value = precio, miOnValueChange = {precio = it}, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, miOnValueChange = {descuento = it}, label = "Descuento")
        SpaceH()
        MainButton(miTexto = "Generar descuento") {
            if(precio != "" && descuento != ""){
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
                totalDescuento = calcularDescuento(precio.toDouble(),descuento.toDouble())
            }else{
                mostrarAlerta = true
            }

        }
        MainButton(miTexto = "Limpiar", color = Color.Red) {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }
        if (mostrarAlerta){
            Alert(
                titulo = "Alerta",
                mensaje = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = {mostrarAlerta = false}
            ){
                
            }
        }
//        Text(text = "buenas")
//        SpaceH()
//        Text(text = "buenas")
//        SpaceH(50.dp)
//        Text(text = "buenas")

    }
}

fun calcularPrecio(precio: Double, descuento: Double): Double{
    val respuesta = precio - calcularDescuento(precio, descuento)
    return  kotlin.math.round(respuesta * 100 )/100.0
}

fun calcularDescuento(precio: Double, descuento: Double): Double{
    val respuesta = precio * (1 - descuento / 100)
    return  kotlin.math.round(respuesta * 100 )/100.0
}