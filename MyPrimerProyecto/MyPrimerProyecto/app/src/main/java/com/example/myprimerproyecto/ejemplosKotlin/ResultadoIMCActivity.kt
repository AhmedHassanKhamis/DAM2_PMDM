package com.example.myprimerproyecto.ejemplosKotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R
import com.example.myprimerproyecto.ejemplosKotlin.EjemploIMCActivity.Companion.IMC_KEY

class ResultadoIMCActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var btnRecalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = intent.extras?.getDouble(IMC_KEY)
            ?: -1.0   // interrogación: si tienes dame eso si no devuelve un 1.0
        initComponentes()
        initUI(resultado)
        initListener()
    }

    private fun initListener() {
        btnRecalcular.setOnClickListener { onBackPressedDispatcher.onBackPressed()}
    }

    private fun initUI(resultado: Double) {
        tvIMC.text = resultado.toString()
        when (resultado) {
            in 0.00..18.50 -> {
                tvResultado.text = getString(R.string.title_bajo_peso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescripcion.text = getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 -> {
                tvResultado.text = getString(R.string.title_peso_normal)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescripcion.text = getString(R.string.description_peso_normal)
            }

            in 25.00..29.99 -> {
                tvResultado.text = getString(R.string.title_sobrepeso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescripcion.text = getString(R.string.description_sobrepeso)
            }

            in 30.00..99.99 -> {
                tvResultado.text = getString(R.string.title_obesidad)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescripcion.text = getString(R.string.description_obesidad)
            }

            else -> {
                tvResultado.text = getString(R.string.error)
                tvResultado.text = getString(R.string.error)
                tvDescripcion.text = getString(R.string.error)
            }

        }
    }

    private fun initComponentes() {
        tvResultado = findViewById(R.id.tvResultado)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        btnRecalcular = findViewById(R.id.btnRecalcular)
    }
}