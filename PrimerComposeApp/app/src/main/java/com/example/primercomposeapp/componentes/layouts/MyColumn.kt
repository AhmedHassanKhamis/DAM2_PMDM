package com.example.primercomposeapp.componentes.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyColumn(modifier: Modifier = Modifier){
//    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center){
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
//        Text(text = "text 3", modifier = Modifier.background(Color.Blue).weight(1f))

    }
//    }
}