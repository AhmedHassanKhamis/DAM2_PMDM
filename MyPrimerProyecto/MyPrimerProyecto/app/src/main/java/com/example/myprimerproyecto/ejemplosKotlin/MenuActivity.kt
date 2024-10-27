package com.example.myprimerproyecto.ejemplosKotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R
import com.example.myprimerproyecto.ejemplosKotlin.primerapp.PrimeraActivity
import com.example.myprimerproyecto.ejemplosKotlin.segundapp.SegundaActivity

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

        val btnPrimerApp = findViewById<Button>(R.id.btnPrimeraApp)
        val btnSegundaApp = findViewById<Button>(R.id.btnSegundaApp)

        btnPrimerApp.setOnClickListener {
            navegar()
        }

        btnSegundaApp.setOnClickListener {
            navegarSegundaApp()
        }

    }

    private fun navegar() {
        val intent = Intent(this, PrimeraActivity::class.java)
        startActivity(intent)

    }

    private fun navegarSegundaApp() {
        val intent = Intent(this, SegundaActivity::class.java)
        startActivity(intent)
    }
}