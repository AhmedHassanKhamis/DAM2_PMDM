package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.primeraApp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R

class PrimeraActivity : AppCompatActivity() {

    private lateinit var btnPrimera: Button
    private lateinit var textViewPrimera: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primera)

        btnPrimera = findViewById(R.id.btnPrimera)
        textViewPrimera = findViewById(R.id.textViewPrimera)

        textViewPrimera.visibility=View.INVISIBLE;
        btnPrimera.text="Buttons down!!"
        //textViewPrimera.setTextColor("#000000")


        btnPrimera.setOnClickListener{
            textViewPrimera.visibility= View.VISIBLE
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}