package com.example.myprimerproyecto.ejemplosKotlin.companionObjects

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R
import com.example.myprimerproyecto.ejemplosKotlin.companionObjects.utils.ToastHelper

class CompanionObjectActivity : AppCompatActivity() {

    private lateinit var tvTextoToast: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_companion_object)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnMostrarToast:Button = findViewById(R.id.btnMostrarToast)
        tvTextoToast = findViewById(R.id.tvTextoToast)

        btnMostrarToast.setOnClickListener {
            ToastHelper.showToast(this, "esto va en el toast")
            tvTextoToast.text = ToastHelper.valorDesdeToast.toString()
        }
    }
}