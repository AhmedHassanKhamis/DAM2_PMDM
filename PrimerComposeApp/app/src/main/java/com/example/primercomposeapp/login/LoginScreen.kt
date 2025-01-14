package com.example.primercomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(
//    widthDp = 100,
//    heightDp = 60,
//    showBackground = true,
//    showSystemUi = true,
//    device = Devices.PIXEL
)
@Composable
fun Ejemplo(a:String = "Pepe"){
    Text("HOLA QUE TAL ", color = Color.White, modifier = Modifier
        .background(Color.Red)
        .padding(all = 40.dp)
        //        .padding(horizontal = 50.dp, vertical = 30.dp)


    )
}