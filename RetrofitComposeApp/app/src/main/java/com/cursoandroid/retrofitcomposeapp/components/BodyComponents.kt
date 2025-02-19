package com.cursoandroid.retrofitcomposeapp.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.cursoandroid.retrofitcomposeapp.Personaje
import com.cursoandroid.retrofitcomposeapp.util.Constantes.Companion.CUSTOM_GREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, showBackButton: Boolean = false, onClickBackButton: ()->Unit, onClickAction: ()->Unit) {
// Este será nuestro topbar genérico para poderlo reutilizar
    TopAppBar(
        title = {Text(text=title, color = Color.White, fontWeight = FontWeight.ExtraBold )},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF2B2626)
        ),
        navigationIcon = {
            if(showBackButton) {
                IconButton(onClick = {onClickBackButton()}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "",
                    tint = Color.White
                        )
                }
            }
        },
        actions = {
            if(!showBackButton) {
                IconButton(onClick = {onClickAction()}) {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}



@Composable
fun CardGame(personaje: Personaje, onClick: ()-> Unit) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage(image = personaje.image)
        }
    }
}


// componente de imagen que reutilizremos tanto en el general como en la vista detalle
@Composable
fun MainImage(image: String) {
    // remeberimagepainter de la librería de coil
    // https://medium.com/geekculture/jetpack-compose-image-loading-using-coil-647a8098c217
    // https://coil-kt.github.io/coil/compose/
    // https://medium.com/@rajputmukesh748/loading-images-with-coil-in-android-xml-and-jetpack-compose-7a004f7738b1
    val image = rememberImagePainter(data = image )

    Image(painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            )
}

@Composable
fun MetaWebSite(url: String) {
    val web = "https://www.metacritic.com/tv/rick-morty/"
    // utilizamos un contexto para poder navegar a un sitio web
    val contexto = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(web) )

    Column {
        Text(
            text="METASCORE",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Button(onClick = {contexto.startActivity(intent)}, colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Gray
        )) {
            Text(text="Sitio web")
        }
    }
}

@Composable
fun ReviewCard(metascore: Int) {
    Card(
        modifier = Modifier
            .padding(16.dp),
        shape= RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(CUSTOM_GREEN)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text=metascore.toString(),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp,
            )
        }
    }
}