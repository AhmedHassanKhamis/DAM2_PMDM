package com.example.myprimerproyecto.ejemplosKotlin.segundapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myprimerproyecto.R

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

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val etNombre = findViewById<EditText>(R.id.etNombre)

        btnEnviar.setOnClickListener {

            val nombre = etNombre.text.toString()

            if(nombre.isNotEmpty()) {
                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("EXTRA_NOMBRE", nombre)

                startActivity(intent)
            }
        }

    }
}