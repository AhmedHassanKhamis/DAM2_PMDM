package com.example.recyclerviewbasico

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
    val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)
}