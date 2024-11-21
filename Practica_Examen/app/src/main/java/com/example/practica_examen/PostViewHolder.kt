package com.example.practica_examen

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
    val imFoto: ImageView = itemView.findViewById(R.id.IvFoto)
    val tvLikes: TextView = itemView.findViewById(R.id.tvLikes)
    val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
}