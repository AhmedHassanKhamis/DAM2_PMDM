package com.example.examen_ahmed_primeraev

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

private lateinit var TvNombre: TextView
private lateinit var TvNombreReal: TextView
private lateinit var IvFoto: ImageView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //SECCION DONDE RECIBO MI VARIABLE DE LA ANTERIOR VIEW
        val resultadoRecibido = intent.getStringExtra("nombre")

        //SECCION DONDE BUSCO LOS COMPONENTES
        TvNombre = findViewById(R.id.tvSuperHeroName)
        TvNombreReal = findViewById(R.id.tvSuperHeroRealName)
        IvFoto = findViewById(R.id.ivSuperHero)

        //SECCION DONDE BINDEO MIS ITEMS
        TvNombre.text = SuperHeroProvider.superHeroList.find { it.superhero.equals(resultadoRecibido,true) }?.superhero.toString()
        TvNombreReal.text = SuperHeroProvider.superHeroList.find { it.superhero.equals(resultadoRecibido,true) }?.realName.toString()
        Glide.with(IvFoto).load(SuperHeroProvider.superHeroList.find { it.superhero.equals(resultadoRecibido,true) }?.photo.toString()).into(IvFoto)

    }
}