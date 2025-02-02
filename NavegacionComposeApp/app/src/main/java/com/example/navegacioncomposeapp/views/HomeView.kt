package com.example.navegacioncomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacioncomposeapp.componentes.ActionButton
import com.example.navegacioncomposeapp.componentes.Espacio
import com.example.navegacioncomposeapp.componentes.MainButton
import com.example.navegacioncomposeapp.componentes.TitleBar
import com.example.navegacioncomposeapp.componentes.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Vista Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    )
    {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController){
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hola que tal")
        TitleView("Vista home")
        Espacio()
        TextField(
            value = opcional,
            onValueChange = {opcional = it},
            label = { Text(text = "valor opcional") }
        )
//        Text(text = opcional)
        MainButton(name ="detalles view", backColor = Color.Red, color = Color.White){
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}