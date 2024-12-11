package com.example.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriasViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val tvCategoriaNombre: TextView = view.findViewById(R.id.tvCategoriaNombre)
    private val divisor: View = view.findViewById(R.id.divisor)
    private val cvCategorias:CardView = view.findViewById(R.id.cvCategorias)

    fun render(tareasCategorias: TareasCategorias, onItemSelected: (Int) -> Unit){

        var color = if (tareasCategorias.isSelected){
            R.color.todo_background_card
        }else{
            R.color.todo_background_disabled
        }

        cvCategorias.setCardBackgroundColor(ContextCompat.getColor(cvCategorias.context, color))

        itemView.setOnClickListener{
            onItemSelected(layoutPosition)

        }

        when(tareasCategorias){
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