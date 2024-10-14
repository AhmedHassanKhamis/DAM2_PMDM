package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.MiApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R

class PrimeraAppActivity : AppCompatActivity() {
        //onCreate es igual al Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Configura que ocupe toda la pantalla
        enableEdgeToEdge()
        setContentView(R.layout.linear_layout_anidados)

        //hace que la app no se superponga a otras apps de sistema (botones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}