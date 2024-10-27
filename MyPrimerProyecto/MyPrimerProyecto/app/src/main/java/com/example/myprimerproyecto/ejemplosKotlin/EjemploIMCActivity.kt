package com.example.myprimerproyecto.ejemplosKotlin

import android.content.Intent
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
import java.text.DecimalFormat

class EjemploIMCActivity : AppCompatActivity() {

    private var isHombreSelected: Boolean = true
    private var isMujerSelected: Boolean = false
    private var pesoActual: Int = 60
    private var edadActual: Int = 29
    private var alturaActual: Int = 120

    private lateinit var viewHombre: CardView
    private lateinit var viewMujer: CardView
    private lateinit var tvAltura: TextView
    private lateinit var rsAltura: RangeSlider
    private lateinit var btnRestarPeso: FloatingActionButton
    private lateinit var btnSumarPeso: FloatingActionButton
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var tvPeso: TextView
    private lateinit var tvEdad: TextView
    private lateinit var btnCalcular: Button

    /* companion object // Es algo así como una variable estática en Java. Un objeto al que se puede acceder desde todas las partes del programa
   así la otra pantalla también podrá
  */
    companion object {
        const val IMC_KEY = "IMC_RESULTADO"
    }

    /*
El modificador lateinit te permite inicializar una propiedad no anulable por fuera del constructor.
Este mecanismo te ayuda cuando deseas asignar el valor de una propiedad después y no deseas usar
comprobaciones de nulos (expresiones if, operador de acceso seguro o aserciones) una vez inicializada.

     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponentes()  // podemos obviarlo para facilitar la comprensión e iniciar aquí los
        // findViewById
        initListener()
        initUI()
    }

    private fun initComponentes() {
        viewHombre = findViewById(R.id.viewHombre)
        viewMujer = findViewById(R.id.viewMujer)
        tvAltura = findViewById(R.id.tvAltura)
        rsAltura = findViewById(R.id.rsAltura)
        btnRestarPeso = findViewById(R.id.btnRestarPeso)
        btnSumarPeso = findViewById(R.id.btnSumarPeso)
        btnSumarEdad = findViewById(R.id.btnSumarEdad)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        tvPeso = findViewById(R.id.tvPeso)
        tvEdad = findViewById((R.id.tvEdad))
        btnCalcular = findViewById(R.id.btnCalcular)

    }

    private fun initListener() {
        viewHombre.setOnClickListener {
            if (!isHombreSelected) {
                changeGender()
                setGeneroColor()
            }
        }
        viewMujer.setOnClickListener {
            if (isHombreSelected) {
                changeGender()
                setGeneroColor()
            }
        }

        rsAltura.addOnChangeListener { _, value, _ ->
            alturaActual = value.toInt()
            tvAltura.text = "$alturaActual cm"
            /* se podría quitar el cero con la coma así:
                 val df = DecimalFormat("#.##") // con esto se "carga" el decimal
                 val result = df.format(value)
                 tvAltura.text = result
            * */
        }
        btnSumarPeso.setOnClickListener {
            pesoActual += 1
            establecerPeso() // importante, en el initUI() hay que llamarlo la primera vez, si no al principio aparece vacío el campo
        }
        btnRestarPeso.setOnClickListener {
            pesoActual -= 1
            establecerPeso()
        }
        btnSumarEdad.setOnClickListener {
            edadActual += 1
            establecerEdad() // importante, en el initUI() hay que llamarlo la primera vez, si no al principio aparece vacío el campo
        }
        btnRestarEdad.setOnClickListener {
            edadActual -= 1
            establecerEdad()
        }
        btnCalcular.setOnClickListener {
            val resultado = calcularIMC()
            navigateToResultado(resultado)
        }
    }

    private fun navigateToResultado(resultado: Double) {
        val intent = Intent(this, ResultadoIMCActivity::class.java)
        intent.putExtra(IMC_KEY, resultado)
        startActivity(intent)
    }

    private fun calcularIMC(): Double {  // EL DOUBLE lo ponemos cuando hagamos el return, cuando terminemos esta pantalla
        val df = DecimalFormat("#.##")
        val imc = pesoActual / (alturaActual.toDouble() / 100 * alturaActual.toDouble() / 100)
        val resultado = df.format(imc).toDouble()
        // Log.i("IMC", "el IMC es: $resultado")
        return resultado
    }

    private fun establecerEdad() {
        tvEdad.text = edadActual.toString()
    }

    private fun establecerPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun changeGender() {
        isHombreSelected = !isHombreSelected
        isMujerSelected = !isMujerSelected

    }

    private fun setGeneroColor() {
        viewHombre.setCardBackgroundColor(getBackgroundColor(isHombreSelected))
        viewMujer.setCardBackgroundColor(getBackgroundColor(isMujerSelected))
    }

    private fun getBackgroundColor(IsSelectedComponent: Boolean): Int {
        val referenciaColor = if (IsSelectedComponent) {
            R.color.background_component_selected  // referencia al color, no es el color de verdad
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, referenciaColor) // esto obtiene el color de verdad
    }

    private fun initUI() {
        //  setGeneroColor()
        establecerPeso()
        establecerEdad()
    }
}