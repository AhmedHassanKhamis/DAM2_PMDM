package com.example.primercomposeapp.componentes.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyRow(modifier: Modifier = Modifier){
    Row(modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center){
        Text(text = "text 1" , modifier = Modifier.background(Color.Red))
        Text(text = "text 2", modifier = Modifier.background(Color.Yellow))
        Text(text = "text 3", modifier = Modifier.background(Color.Blue))
    }
}