package com.example.superheroes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val realName = view.findViewById<TextView>(R.id.tvSuperHeroRealName)
    val publisher = view.findViewById<TextView>(R.id.tvSuperHeroPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)

    // este viewHolder siempre se va a llamar con cada objeto de la vista
    // esta clase debe recibir por parámetro la vista, que la creamos en el onCreateViewHolder
    // del adapter
    fun render(superHeroModel: SuperHero) {
        // el nombre de la función se lo asigno yo, con el nombre que quiera, le puse render

        // esta función se va a llamar automáticamente por cada item del listado
        superHero.text = superHeroModel.superhero
        realName.text = superHeroModel.realName
        publisher.text = superHeroModel.publisher
        // para incluir la ruta de una foto en internet hay que pedir el permiso en manifest.xml
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
       // con esta línea si pinchamos en la imagen se ejecutaría el Toast
        photo.setOnClickListener {
            Toast.makeText(photo.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
        }
         // si queremos pinchar en cualquier parte de la view de un superheroe
        // y se muestre el toast, lo podríamos hacer con un listener en un compoenente
        // que se llama itemView:

        itemView.setOnClickListener {
            Toast.makeText(photo.context, superHeroModel.superhero, Toast.LENGTH_SHORT).show()
        }
    }

}