package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriasViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvCategoriaNombre: TextView = view.findViewById(R.id.tvCategoriaNombre)
    private val divisor: View = view.findViewById(R.id.divisor)

    fun render(tareasCategorias: TareasCategorias){


        val color = when(tareasCategorias){
            TareasCategorias.Negocio -> {
                tvCategoriaNombre.text = "Negocios"
                //LLAMAMOS AL CONTEXTO DEL OBJETO A CAMBIAR

                divisor.setBackgroundColor(ContextCompat.getColor(divisor.context,R.color.todo_business_category))

            }
            TareasCategorias.Otros -> {
                tvCategoriaNombre.text = "Otros"
                divisor.setBackgroundColor(ContextCompat.getColor(divisor.context,R.color.todo_other_category))
            }
            TareasCategorias.Personal -> {
                tvCategoriaNombre.text = "Personal"
                divisor.setBackgroundColor(ContextCompat.getColor(divisor.context,R.color.todo_personal_category))
            }
        }
    }
}