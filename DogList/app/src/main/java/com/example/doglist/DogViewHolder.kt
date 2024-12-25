package com.example.doglist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doglist.databinding.ItemDogBinding

class DogViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemDogBinding.bind(view)



    fun bind(imagen: String){
        binding.ivDog
        Glide.with(binding.ivDog).load(imagen).into(binding.ivDog)
    }


}