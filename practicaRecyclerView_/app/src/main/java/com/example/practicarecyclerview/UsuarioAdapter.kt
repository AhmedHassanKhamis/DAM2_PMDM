package com.example.practicarecyclerview

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UsuarioAdapter(val usuarios: List<Usuario>) : RecyclerView.Adapter<UsuarioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario,parent,false)
        return  UsuarioViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        Glide.with(holder.imFoto).load(usuario.foto).into(holder.imFoto)
        holder.tvNombre.text = usuario.nombre + " " + usuario.apellido
        holder.tvEmail.text = usuario.email
    }

}