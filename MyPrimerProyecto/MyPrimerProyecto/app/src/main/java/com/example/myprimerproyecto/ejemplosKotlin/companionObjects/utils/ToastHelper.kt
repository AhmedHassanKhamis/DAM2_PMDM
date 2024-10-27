package com.example.myprimerproyecto.ejemplosKotlin.companionObjects.utils

import android.content.Context
import android.widget.Toast

class ToastHelper {
    companion object {
        fun showToast(contexto: Context, mensaje: String) {
            Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show()
        }
        val valorDesdeToast ="esto está llamándose desde toast"
    }
}