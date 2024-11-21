package com.example.examen_ahmed_primeraev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private lateinit var CvLinear: CardView
private lateinit var CvGrid: CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //SECCION BUSQUEDA DE COMPONENTES
        CvLinear = findViewById(R.id.CvLinear)
        CvGrid = findViewById(R.id.CvGrid)

        //SECCION DE EVENTOS DE LAS CARDS PARA ELEGIR COMO SE ORGANIZAN

        CvLinear.setOnClickListener {
                val layout = "Linear"
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("layout",layout)
                startActivity(intent)
        }

        CvGrid.setOnClickListener {
            val layout = "Grid"
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("layout",layout)
            startActivity(intent)
        }
    }
}