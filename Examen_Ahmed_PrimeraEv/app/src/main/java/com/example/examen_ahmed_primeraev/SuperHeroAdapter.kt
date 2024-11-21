package com.example.examen_ahmed_primeraev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class SuperHeroAdapter(private val superHeroList: List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        /* devuelve a nuestro viewHolder creado, esto es SuperHeroViewHolder, el item, el layout que va
            a poder modificar el viewHolder. O sea el item_superhero.xml
            Esto lo hacemos "inflando" el layout
        */
        // para sacar un contexto cuando no estamos en una activity lo podemos coger de
        // cualquiera de las vistas, como onCreateViewHolder recibe un parent de tipo ViewHolder
        // lo podemos sacar de ahí
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false) )

    }

    override fun getItemCount(): Int {
        // devuelve el tamaño del listado de superheros
        return superHeroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        // este método lo hacemos cuando hayamos desarrollado primero la clase SuperHeroViewHolder
        // este método va a pasar por cada uno de los items y va a llamar a la función render
        // pasándole dicho item
        // recibe como parámetros la instancia del viewHolder y su posición:
        // holder: SuperHeroViewHolder, position: Int
        val item = superHeroList[position]
        holder.render(item)
    }
}

/*
    esta clase no está recibiendo aún el listado de superheros
    le tenemos que decir en el adaptador que va a recibir una lista de superheroes,
    por eso le ponemos
    class SuperHeroAdapter (val superHeroList: List<SuperHero>)


 */