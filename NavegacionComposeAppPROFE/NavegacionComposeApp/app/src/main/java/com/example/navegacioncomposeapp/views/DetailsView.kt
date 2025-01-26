package com.example.navegacioncomposeapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacioncomposeapp.componentes.Espacio
import com.example.navegacioncomposeapp.componentes.MainButton
import com.example.navegacioncomposeapp.componentes.MainIconButton
import com.example.navegacioncomposeapp.componentes.TitleBar
import com.example.navegacioncomposeapp.componentes.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {TitleBar(name = "Detalle View")},
                colors= TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Blue
                    ),
                 navigationIcon = {
                     MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                         navController.popBackStack()
                     }
                 }
            )
        }

    ) {
       ContentDetailView(navController)
    }
}

@Composable
fun ContentDetailView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("vista detalle")
        Espacio()
        MainButton(name = "Retornar home", backColor = Color.Blue, color = Color.White) {
          //  println("botón genércio en Details")
            navController.popBackStack()
        }
    }
}