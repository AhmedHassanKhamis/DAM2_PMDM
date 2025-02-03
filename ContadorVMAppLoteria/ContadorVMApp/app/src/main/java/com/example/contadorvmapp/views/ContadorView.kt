package com.example.contadorvmapp.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadorvmapp.viewModels.ContadorVIewModel

@Composable
fun ContadorView(modifier: Modifier=Modifier,viewModel: ContadorVIewModel) {

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Text(text = viewModel.contador.value.toString(), fontSize = 40.sp, fontWeight = FontWeight.Bold)
        FloatingActionButton(onClick = {viewModel.add()}, modifier = Modifier
            .align(Alignment.Center)
            .padding(15.dp)) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = Color.White)
        }

    }
}