package com.example.superheroes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.SuperHeroProvider
import com.example.superheroes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recicler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()

    }

    fun initRecyclerView() {
        // recuperamos el RecyclerView
        val manager = LinearLayoutManager(this)
        //  recyclerView.layoutManager = GridLayoutManager(this, 2)
        // val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
        recyclerView.layoutManager = manager
        recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.superHeroList)
        // recyclerView.addItemDecoration(decoration)
    }
}

/* los recyclerview funcionan a través de listas

         le vamos a pasar una lista al recyclerview, y este recycler sabrá que tiene que
         crear una celda (un item) para cada uno objetos de la lista. Este item lo tenemos
         que diseñar primero en el xml

     Hay varios pasos para realizar un recyclerview, ya que hay dos clases que tenemos
     que crear:

     - adapter, es la clase que cogerá la información y la meterá en el recyclerview
     - viewHolder, clase que se encargará de pintar las celdas (los items del listado)

      */

/*
    PARA CARGAR IMÁGENES NECESITAMOS UNA LIBRERÍA EXTERNA,
    usaremos Glide (otra famosa es Picasso)
    hay que tocar en el fichero libs.versions.toml
    y en build.gradle.kts del módulo
    https://github.com/android/nowinandroid/blob/main/gradle/libs.versions.toml
    https://codea.app/blog/agregar-dependencias-version-catalogs-libsversionstoml

 */