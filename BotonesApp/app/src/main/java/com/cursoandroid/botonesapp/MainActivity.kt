package com.cursoandroid.botonesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursoandroid.botonesapp.ui.theme.BotonesAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotonesAppTheme {
               Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                   Contenido(modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotonesAppTheme {
        Greeting("Android")
    }
}



@Composable
fun Contenido(modifier: Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BotonNormal()
        Espacio()
        BotonNormal2()
        Espacio()
        BotonTexto()
        Espacio()
        BotonOutline()
        Espacio()
        BotonIcono()
        Espacio()
        BotonSwitch()
        Espacio()
        DarkMode()

    }
}

@Composable
fun BotonNormal() {
    Button(onClick = {}, enabled = false) {
        Text(text = "mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2() {
    Button(onClick = {}, colors= ButtonDefaults.buttonColors(
        // backgroundColor = Color.Red, anteriormente
        containerColor = Color.Red
    )
    ) {
        Text(text = "mi botón", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = {}) {
        Text(text = "mi botón de texto", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline() {
    OutlinedButton(onClick = {}, border = BorderStroke(3.dp, Color.Blue)) {
        Text(text = "mi botón OutLine", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = {}, colors = IconButtonDefaults.iconButtonColors(Color.Yellow)) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "mi icono",
            tint = Color.Red,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun BotonSwitch() {
    var cambiar by remember { mutableStateOf(false) }
    // Switch(checked=cambiar, onCheckedChange = { it} )
    Switch(checked=cambiar, onCheckedChange = { cambiar = it},
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,
            uncheckedThumbColor = Color.Yellow,
            uncheckedTrackColor = Color.Magenta
        )
    )
}

@Composable
fun DarkMode() {
    Button(onClick = {}) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "modo oscuro")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text="modo oscuro", fontSize = 30.sp)
    }
}

@Composable
fun Espacio() {
    Spacer(modifier= Modifier.height(10.dp))
}