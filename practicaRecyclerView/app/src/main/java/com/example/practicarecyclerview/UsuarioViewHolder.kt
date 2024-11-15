package com.example.practicarecyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imFoto: ImageView = itemView.findViewById(R.id.IvFoto)
    val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
    val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
}