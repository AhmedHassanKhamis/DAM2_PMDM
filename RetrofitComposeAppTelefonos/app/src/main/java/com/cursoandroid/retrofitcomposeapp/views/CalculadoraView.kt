package com.cursoandroid.retrofitcomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.cursoandroid.retrofitcomposeapp.components.MainTopBarAhmed


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculadoraView(navController: NavController) {



    Scaffold(
        topBar = {
            MainTopBarAhmed(title = "Calculadora", showBackButton = true, onClickBackButton = {
                navController.popBackStack() }) { }
        }
    ) {
        ContentCalculadoraView(it)
    }

}



@Composable
fun ContentCalculadoraView(pad: PaddingValues) {

    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var total by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(pad).fillMaxSize().background(color = androidx.compose.ui.graphics.Color.Companion.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text(text = "Numero 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text(text = "Numero 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedButton(onClick = {
            total = (numero1.toIntOrNull() ?: 0) + (numero2.toIntOrNull() ?: 0)
        }) {
            Text(text = "Sumar")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Total: $total")
    }

}