package com.example.todoapp

data class Tarea(val nombre:String, val categoria:TareasCategorias, var isSelected:Boolean = false)
