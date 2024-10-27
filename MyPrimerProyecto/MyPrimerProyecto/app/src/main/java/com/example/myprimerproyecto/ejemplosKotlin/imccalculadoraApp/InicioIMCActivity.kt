package com.example.myprimerproyecto.ejemplosKotlin.imccalculadoraApp

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import kotlin.math.pow

private var isHombreSeleccionado: Boolean = true
private var isMujerSeleccionada: Boolean = false
private var pesoActual: Int = 64
private var edadActual: Int = 29
private var alturaActual: Int = 120

private lateinit var viewHombre: CardView
private lateinit var viewMujer: CardView
private lateinit var tvAltura: TextView
private lateinit var rsAltura: RangeSlider
private lateinit var btnRestarPeso: FloatingActionButton
private lateinit var btnSumarPeso: FloatingActionButton
private lateinit var tvPeso: TextView
private lateinit var tvEdad: TextView
private lateinit var btnRestarEdad: FloatingActionButton
private lateinit var btnSumarEdad: FloatingActionButton
private lateinit var btnCalcularIMC: Button

class InicioIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        iniciarListener()
        initUI()
    }



    private fun iniciarComponentes() {
        viewHombre = findViewById(R.id.viewHombre)
        viewMujer = findViewById(R.id.viewMujer)
         tvAltura = findViewById(R.id.tvAltura)
         rsAltura = findViewById(R.id.rsAltura)
         btnSumarPeso = findViewById(R.id.btnSumarPeso)
         btnRestarPeso = findViewById(R.id.btnRestarPeso)
        tvPeso = findViewById(R.id.tvPeso)
        tvEdad = findViewById(R.id.tvEdad)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        btnSumarEdad = findViewById(R.id.btnSumarEdad)
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC)
    }

    private fun iniciarListener() {

        viewHombre.setOnClickListener{
            if(!isHombreSeleccionado) {
                changeGenero()
                setGeneroColor()
            }

        }
        viewMujer.setOnClickListener {
            if(isHombreSeleccionado) {
                changeGenero()
                setGeneroColor()
            }
        }

        rsAltura.addOnChangeListener { _, value, _ ->
            alturaActual = value.toInt()
            tvAltura.text = "${alturaActual} cm"
        }

        btnSumarPeso.setOnClickListener{
            pesoActual += 1
            establecerPeso()
        }

        btnRestarPeso.setOnClickListener{
            pesoActual -= 1
            establecerPeso()
        }

        btnRestarEdad.setOnClickListener {
            edadActual -=1
            establecerEdad()
        }

        btnSumarEdad.setOnClickListener {
            edadActual += 1
            establecerEdad()
        }

        btnCalcularIMC.setOnClickListener {
            val resultado = calcularIMC()
            navegarAResultado(resultado)
        }
    }

    private fun navegarAResultado(resultado: Double) {
        val intent = Intent(this,ResultadoIMCActivity::class.java)
        intent.putExtra("IMC_KEY", resultado)
        startActivity(intent)
    }

    private fun calcularIMC(): Double {
       // val df = DecimalFormat("#.##")
        val alturaMetros = alturaActual.toDouble() /100
        val imc = pesoActual / alturaMetros.pow(2)
    //    val resultado = df.format(imc).toDouble()
        return imc
    }

    private fun establecerEdad() {
        tvEdad.text = edadActual.toString()
    }

    private fun establecerPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun changeGenero() {
        isHombreSeleccionado = !isHombreSeleccionado
        isMujerSeleccionada = !isMujerSeleccionada
    }

    private fun setGeneroColor() {
        viewHombre.setCardBackgroundColor(getBackgroundColor(isHombreSeleccionado))
        viewMujer.setCardBackgroundColor(getBackgroundColor(isMujerSeleccionada))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        //R.color.background_component_selected
        val referenciaColor = if (isSelectedComponent) {
            R.color.background_component_selected
        }else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, referenciaColor)
    }

    private fun initUI() {
        establecerPeso()
        establecerEdad()
    }
}