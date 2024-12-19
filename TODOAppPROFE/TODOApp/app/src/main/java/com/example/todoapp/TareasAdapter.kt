package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TareasAdapter(var tareas: List<Tarea>, private val onTareaSeleccionada: (Int)->Unit): RecyclerView.Adapter<TareasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo_tarea, parent, false)
        return TareasViewHolder(view)
    }

    override fun getItemCount(): Int {
       return tareas.size;
    }

    override fun onBindViewHolder(holder: TareasViewHolder, position: Int) {
        holder.render(tareas[position])
        holder.itemView.setOnClickListener{
            onTareaSeleccionada(position)
        }
    }
}