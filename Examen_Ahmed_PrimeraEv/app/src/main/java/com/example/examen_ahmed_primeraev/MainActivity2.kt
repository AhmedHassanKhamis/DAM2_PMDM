package com.example.examen_ahmed_primeraev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var CvSuperHeroesArray : Array<CardView>

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()


    }

    //REALIZO UNA FUNCION PARA HACER QUE SE GENERE EL RECYCLER VIEW Y QUE ME ASIGNE EL LAYOUT CORRESPONDIENTE
    fun initRecyclerView() {
        // recuperamos el RecyclerView
        val resultadoRecibido = intent.getStringExtra("layout")
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
        if (resultadoRecibido.equals("Linear",true))
            recyclerView.layoutManager = LinearLayoutManager(this)
        else
            recyclerView.layoutManager = GridLayoutManager(this, 2)

        // val decoration = DividerItemDecoration(this, manager.orientation)
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
        // recyclerView.addItemDecoration(decoration)
    }
}