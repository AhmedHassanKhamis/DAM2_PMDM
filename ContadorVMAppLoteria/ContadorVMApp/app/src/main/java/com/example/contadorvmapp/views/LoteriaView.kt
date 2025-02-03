package com.example.contadorvmapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadorvmapp.viewModels.LoteriaViewModel

@Composable
fun LoteriaView(modifier: Modifier=Modifier,viewModel:LoteriaViewModel){
    val numerosloteria=viewModel.numeroLoteria.value
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        if(numerosloteria.isEmpty()){
        Text(text = "Numero de la loteria", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }else{
            LotoNumero(numeros = numerosloteria)
        }
        Button(onClick = { viewModel.generarNumerosLoteria() }) {
            Text(text = "Generar numero", fontSize =20.sp, fontWeight = FontWeight.Bold)
        }

    }
}

@Composable
fun LotoNumero(numeros:List<Int>){
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(numeros){
            numero-> Box(contentAlignment = Alignment.Center, modifier = Modifier
            .padding(horizontal = 4.dp)
            .size(40.dp)
            .background(
                Color.Red, CircleShape
            )){
                Text(text = numero.toString(),color=Color.White, fontSize = 24.sp)
          }
        }
    }

}
