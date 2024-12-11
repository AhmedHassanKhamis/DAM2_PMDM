package com.example.todoapp

sealed class TareasCategorias(var isSelected : Boolean = true){
    object Personal: TareasCategorias()
    object Negocio: TareasCategorias()
    object Otros: TareasCategorias()
}
