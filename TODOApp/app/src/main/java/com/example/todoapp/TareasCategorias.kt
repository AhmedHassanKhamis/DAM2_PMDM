package com.example.todoapp

sealed class TareasCategorias {
    object Personal: TareasCategorias()
    object Negocio: TareasCategorias()
    object Otros: TareasCategorias()
}
