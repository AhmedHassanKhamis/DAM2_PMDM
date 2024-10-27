package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.imccalculadoraApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R
import com.google.android.material.slider.RangeSlider

private var isMujer:Boolean=true

    private lateinit var viewHombre:CardView
    private lateinit var viewMujer:CardView

    private lateinit var tvAltura:TextView
    private lateinit var rangeAltura:RangeSlider

class ImcInicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarComponentes()
        iniciarListener()

    }

    private fun iniciarListener() {
        viewHombre.setOnClickListener{
            if(isMujer){
                checkGenero()
                setGeneroColor()
                }


        }
        viewMujer.setOnClickListener {
            if(!isMujer){
                checkGenero()
                setGeneroColor()
            }

        }



        btnSumarP
    }

    private fun checkGenero() {
        isMujer=!isMujer

            }

    private fun setGeneroColor() {
        viewMujer.setCardBackgroundColor(getBackgroundColor(isMujer))
        viewHombre.setCardBackgroundColor(getBackgroundColor(!isMujer))
    }


    private fun getBackgroundColor(isMujer: Boolean) :Int {
        val color=
        if(isMujer) {
            R.color.background_component_selected
        }
        else{
            R.color.background_component
        }
        return ContextCompat.getColor(this,color)
    }

    private fun iniciarComponentes() {
        viewMujer=findViewById(R.id.cardViewMujer)
        viewHombre=findViewById(R.id.cardViewHombre)
    }
}
