package com.example.navegacioncomposeapp.views

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navegacioncomposeapp.componentes.Espacio
import com.example.navegacioncomposeapp.componentes.MainButton
import com.example.navegacioncomposeapp.componentes.MainIconButton
import com.example.navegacioncomposeapp.componentes.TitleBar
import com.example.navegacioncomposeapp.componentes.TitleView


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TitleBar( name = "Detail view")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon= Icons.AutoMirrored.Filled.ArrowBack){
                        navController.popBackStack()
                    }
                }
            )
        },
    ) {
        ContentDetailView(navController, id, opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("Vista detalle")
        Espacio()
        TitleView(name= id.toString())
        Espacio()
        if(opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name=opcional.orEmpty())
        }
        MainButton(name ="Return home", backColor = Color.Blue, color = Color.White){
            navController.popBackStack()
        }
    }
}