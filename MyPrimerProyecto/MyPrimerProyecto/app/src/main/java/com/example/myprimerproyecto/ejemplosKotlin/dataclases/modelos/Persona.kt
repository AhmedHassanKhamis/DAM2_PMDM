package com.example.myprimerproyecto.ejemplosKotlin.dataclases.modelos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Persona(
    val nombre: String,
    val edad: Int,
    val email: String
): Parcelable