package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.segundaApp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnEnviar = findViewById<AppCompatButton>(R.id.btnEnviar)
        val etNombre = findViewById<EditText>( R.id.etNombre)

        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString()

            if(nombre.isNotEmpty()) {
                val intent = Intent(this,ResultActivity::class.java)
                //El intent es (Donde estoy, a donde voy)

                intent.putExtra("EXTRA_NOMBRE",nombre)
                startActivity(intent)


            }
        }


    }
}