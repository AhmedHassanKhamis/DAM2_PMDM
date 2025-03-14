package com.example.primercomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.primercomposeapp.componentes.layouts.MyBox
import com.example.primercomposeapp.componentes.layouts.MyColumn
import com.example.primercomposeapp.componentes.layouts.MyCombinados
import com.example.primercomposeapp.componentes.layouts.MyPruebaRepaso
import com.example.primercomposeapp.componentes.layouts.MyRow
import com.example.primercomposeapp.login.Greeting
import com.example.primercomposeapp.ui.theme.PrimerComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    MyBox()
//                    MyColumn( Modifier.padding(innerPadding))
//                    MyRow(Modifier.padding(innerPadding))
//                    MyCombinados(Modifier.padding(innerPadding))
                    MyPruebaRepaso(Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerComposeAppTheme {
        Greeting("Android")
    }
}