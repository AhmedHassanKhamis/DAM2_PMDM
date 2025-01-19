package com.example.primercomposeapp.componentes.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyPruebaRepaso (modifier: Modifier = Modifier){
    Column {
        Box(modifier = Modifier.weight(1f).background(Color.Cyan).fillMaxWidth(), contentAlignment = Alignment.Center){
            Text("Ejemplo1", color = Color.Black)
        }
        Row (modifier = Modifier.weight(1f).background(Color.White).fillMaxWidth()) {
            Box(modifier = Modifier.weight(1f).background(Color.Red).fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.Center){
                Text("Ejemplo2", color = Color.Black)
            }
            Box(modifier = Modifier.weight(1f).background(Color.Green).fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.Center){
                Text("Ejemplo3", color = Color.Black)
            }
        }

        Box(modifier = Modifier.weight(1f).background(Color.Magenta).fillMaxWidth(), contentAlignment = Alignment.BottomCenter){
            Text("Ejemplo4", color = Color.Black)
        }

    }
}