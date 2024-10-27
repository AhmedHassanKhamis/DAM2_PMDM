package com.example.myprimerproyecto.ejemplosKotlin.applicacionDenigrante

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R


private lateinit var cvTexto : CardView
private lateinit var tvTexto : TextView
private lateinit var tvTexto2: TextView
private lateinit var btnPocho: Button


class ejemploAppDenigranteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo_app_denigrante)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        iniciarListeners()
        initUi()
    }

    private fun initUi() {
        cvTexto.setCardBackgroundColor(getColor(R.color.black))
    }

    private fun iniciarListeners() {
        btnPocho.setOnClickListener {
            insultar()
        }
    }

    private fun insultar() {
        tvTexto.text = "¿QUE BUSCAS?"
        tvTexto2.text = "VAYA BOBO JAJAJAJA"

    }

    private fun iniciarComponentes() {
        cvTexto = findViewById(R.id.cvTexto)
        tvTexto = findViewById(R.id.tvInsulto)
        tvTexto2 = findViewById(R.id.tvMolestar)
        btnPocho = findViewById(R.id.btnPocho)
    }
}