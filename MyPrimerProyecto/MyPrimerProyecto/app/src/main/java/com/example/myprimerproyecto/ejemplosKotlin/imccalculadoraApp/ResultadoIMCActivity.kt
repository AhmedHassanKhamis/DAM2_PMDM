package com.example.myprimerproyecto.ejemplosKotlin.imccalculadoraApp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R

class ResultadoIMCActivity : AppCompatActivity() {

    private lateinit var tvResultado2: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescripcion2: TextView
    private lateinit var btnRecalcular2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_imcactivity2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var resultado = intent.extras?.getDouble("IMC_KEY") ?: -1.0
        initComponet()
        initUI(resultado)
        initListener()
    }


    private fun initComponet() {
        tvResultado2 = findViewById(R.id.tvResultado2)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescripcion2 = findViewById(R.id.tvDescripcion2)
        btnRecalcular2 = findViewById(R.id.btnRecalcular2)
    }

    private fun initListener() {
       btnRecalcular2.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        // para navegar atrás
    }

    private fun initUI(resultado: Double) {
        val df = DecimalFormat("#.##")
        tvIMC.text = df.format(resultado).toString()

        when(resultado) {
            in 0.00..18.50 -> {
                tvResultado2.text = getString(R.string.title_bajo_peso)
                tvResultado2.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescripcion2.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 ->{
                tvResultado2.text = getString(R.string.title_peso_normal)
                tvResultado2.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescripcion2.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 ->{
                tvResultado2.text = getString(R.string.title_sobrepeso)
                tvResultado2.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvDescripcion2.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.99 ->{
                tvResultado2.text = getString(R.string.title_obesidad)
                tvResultado2.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvDescripcion2.text = getString(R.string.description_obesidad)
            }
            else -> {
                tvResultado2.text = getString(R.string.error)
                tvIMC.text = getString(R.string.error)
                tvDescripcion2.text = getString(R.string.error)
            }
        }
    }

}