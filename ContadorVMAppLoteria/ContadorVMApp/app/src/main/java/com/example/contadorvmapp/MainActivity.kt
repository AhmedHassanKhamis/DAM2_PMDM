package com.example.contadorvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.contadorvmapp.ui.theme.ContadorVMAppTheme
import com.example.contadorvmapp.viewModels.ContadorVIewModel
import com.example.contadorvmapp.viewModels.LoteriaViewModel
import com.example.contadorvmapp.views.ContadorView
import com.example.contadorvmapp.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel:ContadorVIewModel by viewModels()
        val viewModelLotery:LoteriaViewModel by viewModels()
        setContent {
            ContadorVMAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //ContadorView(Modifier.padding(innerPadding),viewModel=viewModel)
                    LoteriaView(modifier = Modifier.padding(innerPadding),viewModel = viewModelLotery)
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
    ContadorVMAppTheme {
        Greeting("Android")
    }
}