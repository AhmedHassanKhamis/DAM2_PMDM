package com.example.myprimerproyecto.ejemplosKotlin.primerapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R

class PrimeraActivity : AppCompatActivity() {

    private lateinit var btnPulsar: Button
    private lateinit var tvSaludar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primera)

        btnPulsar = findViewById<Button>(R.id.btnPulsar)
        tvSaludar = findViewById<TextView>(R.id.tvSaludar)

        btnPulsar.text = "hola tronco"
        //btnPulsar.setTextColor("fff"

        btnPulsar.setOnClickListener {
            tvSaludar.visibility = View.VISIBLE
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}