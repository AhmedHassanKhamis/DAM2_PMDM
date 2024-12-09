package com.example.pruebas

fun main() {
    // 1. Calcular área o perímetro
    fun calcular(ancho: Int, alto: Int, operacion: (Int, Int) -> Int): Int {
        return operacion(ancho, alto)
    }
    val area = calcular(5, 10) { ancho, alto -> ancho * alto }
    val perimetro = calcular(5, 10) { ancho, alto -> 2 * (ancho + alto) }
    println("Área: $area")
    println("Perímetro: $perimetro")

    // 2. Filtrar números pares
    fun filtrarNumeros(lista: List<Int>, condicion: (Int) -> Boolean): List<Int> {
        return lista.filter(condicion)
    }
    val numeros = listOf(1, 2, 3, 4, 5, 6)
    val numerosPares = filtrarNumeros(numeros) { it % 2 == 0 }
    println("Números pares: $numerosPares")

    // 3. Convertir palabras a mayúsculas
    fun palabraAMayusculas(lista: List<String>, transformacion: (String) -> String): List<String> {
        return lista.map(transformacion)
    }
    val palabras = listOf("hola", "mundo")
    val palabrasMayusculas = palabraAMayusculas(palabras) { it.uppercase() }
    println("Palabras en mayúsculas: $palabrasMayusculas")

    // 4. Multiplicar lista de números
    fun multiplicarLista(lista: List<Int>, multiplicacion: (Int) -> Int): List<Int> {
        return lista.map(multiplicacion)
    }
    val numerosMultiplicados = multiplicarLista(numeros) { it * 2 }
    println("Números multiplicados: $numerosMultiplicados")

    // 5. Longitudes de palabras
    fun longitudesPalabras(lista: List<String>, longitud: (String) -> Int): List<Int> {
        return lista.map(longitud)
    }
    val longitudes = longitudesPalabras(palabras) { it.length }
    println("Longitudes de palabras: $longitudes")

    // 6. Agregar prefijo a nombres
    fun agregarPrefijo(lista: List<String>, prefijo: String, concatenacion: (String, String) -> String): List<String> {
        return lista.map { concatenacion(prefijo, it) }
    }
    val nombres = listOf("Juan", "Ana")
    val nombresConPrefijo = agregarPrefijo(nombres, "Sr./Sra. ") { prefijo, nombre -> prefijo + nombre }
    println("Nombres con prefijo: $nombresConPrefijo")

    // 7. Procesar lista de números
    fun procesarLista(
        lista: List<Int>,
        transformacion: (Int) -> Int,
        condicion: (Int) -> Boolean
    ): List<Int> {
        return lista.map(transformacion).filter(condicion)
    }
    val numerosProcesados = procesarLista(numeros, { it * 2 }, { it > 5 })
    println("Números procesados: $numerosProcesados")

    // 8. Sumar resultados de la lista procesada
    val sumaResultados = numerosProcesados.sum()
    println("Suma de resultados: $sumaResultados")
}
