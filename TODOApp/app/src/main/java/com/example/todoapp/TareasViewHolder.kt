package com.example.todoapp

import android.content.res.ColorStateList
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TareasViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val tvTarea:TextView= view.findViewById(R.id.tvTareas)
    val cbTarea:CheckBox=view.findViewById(R.id.cbTarea)

    fun render(tarea: Tarea){

        tvTarea.text=tarea.nombre

        val color= when(tarea.categoria){
            TareasCategorias.Negocio -> R.color.todo_business_category
            TareasCategorias.Otros -> R.color.todo_other_category
            TareasCategorias.Personal -> R.color.todo_personal_category
        }

        cbTarea.buttonTintList= ColorStateList.valueOf(
            ContextCompat.getColor(cbTarea.context,color)
        )





    }
}