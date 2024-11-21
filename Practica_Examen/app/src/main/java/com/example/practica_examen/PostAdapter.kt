package com.example.practica_examen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(val posts: List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_foto,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        Glide.with(holder.imFoto).load(post.foto).into(holder.imFoto)
        holder.tvNombre.text = post.usuario
        holder.tvLikes.text = post.likes.toString()
        holder.tvDescripcion.text = post.descripcion
    }


}