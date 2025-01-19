package com.example.primercomposeapp.componentes.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyCombinados(modifier : Modifier = Modifier) {
    Column {
        Box(modifier = Modifier.weight(1f).background(Color.Red).fillMaxWidth())
        Box(modifier = Modifier.weight(1f).background(Color.Blue).fillMaxWidth()){
            Row {
                Box(modifier = Modifier
                    .weight(2f)
                    .background(Color.Gray)
                    .height(50.dp))
                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .height(180.dp),
                    contentAlignment = Alignment.Center){
                    Text("hola")
                }
            }
        }
        Box(modifier = Modifier.weight(1f).background(Color.Yellow).fillMaxWidth())
    }
}