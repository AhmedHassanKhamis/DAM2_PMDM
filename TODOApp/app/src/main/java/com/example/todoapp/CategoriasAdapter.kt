package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriasAdapter(private val categorias: List<TareasCategorias>):
    RecyclerView.Adapter<CategoriasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasViewHolder {
        val view = LayoutInflater.from(parent.context).
            inflate(R.layout.item_tarea_categoria, parent, false)

        return CategoriasViewHolder(view)
    }

    override fun getItemCount() = categorias.size

    override fun onBindViewHolder(holder: CategoriasViewHolder, position: Int) {
        holder.render(categorias[position])
    }
}