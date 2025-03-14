package com.cursoandroid.retrofitcomposeapp

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
import com.cursoandroid.retrofitcomposeapp.navigation.NavManager
import com.cursoandroid.retrofitcomposeapp.ui.theme.RetrofitComposeAppTheme
import com.cursoandroid.retrofitcomposeapp.viewModel.GamesViewModel
import com.cursoandroid.retrofitcomposeapp.views.HomeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: GamesViewModel by viewModels()
        setContent {
            RetrofitComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                 //   HomeView(modifier = Modifier.padding(innerPadding), viewModel)
                    NavManager(modifier = Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

