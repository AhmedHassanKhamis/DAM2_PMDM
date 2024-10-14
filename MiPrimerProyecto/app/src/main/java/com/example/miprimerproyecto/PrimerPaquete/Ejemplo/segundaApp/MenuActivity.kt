package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.segundaApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        val btnPag1= findViewById<Button>(R.id.btnPag1)
        val btnPag2= findViewById<Button>(R.id.btnPag2)


        btnPag1.setOnClickListener{
            navegar1()
        }

        btnPag2.setOnClickListener{
            navegar2()
        }
    }


    private fun navegar2() {
        val intent= Intent(this, SegundaActivity::class.java)
        startActivity(intent)
    }

    private fun navegar1() {
        val intent= Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }
}