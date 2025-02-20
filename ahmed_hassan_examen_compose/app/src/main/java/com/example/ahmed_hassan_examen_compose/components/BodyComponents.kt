package com.example.ahmed_hassan_examen_compose.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


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
        }
    )
}


@Composable
fun MainButton(miTexto: String,habilitado: Boolean = true, color: Color = MaterialTheme.colorScheme.primary, miOnclick: ()-> Unit){
    OutlinedButton(onClick = miOnclick, colors = ButtonDefaults.outlinedButtonColors(
        contentColor = color,
        containerColor = Color.Transparent
    ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        enabled = habilitado
    ) {
        Text(text = miTexto)
    }
}

@Composable
fun MainTextField(value: String, miOnValueChange: (String)->Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = miOnValueChange,
        label = {Text(text=label, color = Color.LightGray)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        colors = OutlinedTextFieldDefaults.colors(Color.LightGray)

        )
}


@Composable
fun SpaceH(size: Dp =10.dp){
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp =10.dp){
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun Alert(
    titulo: String,
    mensaje: String,
    confirmText: String,
    onConfirmClick: ()->Unit,
    onDismissClick: ()->Unit
){
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = titulo) },
        text = {Text(text = mensaje)},
        confirmButton = {
            Button(onClick={onConfirmClick()}){
                Text(text = confirmText)
            }
        }
    )
}
