package com.example.ejecicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var etNombre: EditText
private lateinit var tvMensaje: TextView
private lateinit var btn1: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etNombre = findViewById(R.id.etNombre)
        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {
            val resultado = etNombre.text.toString()

            if (resultado.isEmpty()){
                Toast.makeText(this, "Debes introducir un nombre", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MostrarNombre::class.java)
                intent.putExtra("resultado",resultado)
                startActivity(intent)
            }
        }
    }




}