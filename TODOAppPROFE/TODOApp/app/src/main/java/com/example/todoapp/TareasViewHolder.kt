package com.example.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TareasViewHolder(view: View):RecyclerView.ViewHolder(view) {

   val tvTarea: TextView = view.findViewById(R.id.tvTarea)
   val cbTarea: CheckBox = view.findViewById(R.id.cbTarea)

    fun render(tarea: Tarea) {
        tvTarea.text = tarea.nombre

        if(tarea.isSelected) {
            // para tachar texto
            tvTarea.paintFlags = tvTarea.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else {
            tvTarea.paintFlags = tvTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbTarea.isChecked = tarea.isSelected

        val color = when(tarea.categoria) {
            TareasCategorias.Negocios -> R.color.todo_business_category
            TareasCategorias.Otros -> R.color.todo_other_category
            TareasCategorias.Personal -> R.color.todo_personal_category
        }

        cbTarea.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTarea.context, color)
        )


    }
}