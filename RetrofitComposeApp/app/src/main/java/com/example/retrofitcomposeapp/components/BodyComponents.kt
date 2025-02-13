package com.example.retrofitcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.retrofitcomposeapp.models.Personaje

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, showBackButton: Boolean = false, onClickBackButton: () -> Unit){
    // este sera nuestro topApp generico para poder reutilizar
    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight =  FontWeight.ExtraBold)},
        colors =  TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF282626)
        ),
        navigationIcon = {
            if (showBackButton){
                IconButton(onClick = {onClickBackButton()}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.White)
                }
            }
        }


    )
}

@Composable
fun CardGame(persona: Personaje,onClick: () -> Unit){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(18.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ){
        //aqui va un composable de imagen personalizado
        Column {
            MainImage(imagen = persona.image)
        }
    }
}

@Composable
fun MainImage(imagen: String,){
    val image = rememberImagePainter(data = imagen)
    Image(painter = image,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .height(250.dp)
        )
}