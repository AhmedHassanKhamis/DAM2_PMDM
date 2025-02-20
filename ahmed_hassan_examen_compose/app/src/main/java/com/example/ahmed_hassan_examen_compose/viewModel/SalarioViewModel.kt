package com.example.ahmed_hassan_examen_compose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SalarioViewModel: ViewModel(){
    var salario by mutableStateOf("")
    var tipoContrato by mutableStateOf("Trabajo Fijo")
    var salarioNeto by mutableStateOf("")
    var contingenciasComunes2 by mutableStateOf("")
    var desempleo2 by mutableStateOf("")
    var irpf2 by mutableStateOf("")
    var formacionProfesional2 by mutableStateOf("")

    fun calcularSalario() {
        val salarioBruto = salario.toDoubleOrNull()
        if (salarioBruto == null || salarioBruto <= 0) {
            salarioNeto = ""
            return
        }

        val contingenciasComunes = salarioBruto * 0.047
        contingenciasComunes2 = String.format("%.2f", contingenciasComunes)
        val formacionProfesional = salarioBruto * 0.001
        formacionProfesional2 = String.format("%.2f", formacionProfesional)
        val ayudasMovilidad = salarioBruto * 0.035
        val desempleo = when (tipoContrato) {
            "Trabajo Fijo" -> salarioBruto * 0.0155
            "Trabajo Temporal" -> salarioBruto * 0.016
            else -> 0.0
        }
        desempleo2 = String.format("%.2f", desempleo)

        // Calcular IRPF
        val irpf = calcularIRPF(salarioBruto)

        val totalDescuentos = contingenciasComunes + formacionProfesional + ayudasMovilidad + desempleo + irpf
        salarioNeto = String.format("%.2f", salarioBruto - totalDescuentos)

    }

    fun calcularIRPF(salarioBruto: Double): Double {
        var irpfTotal = 0.0
        var salarioRestante = salarioBruto

        if (salarioRestante > 0) {
            val tramo1 = minOf(12450.0, salarioRestante)
            irpfTotal += tramo1 * 0.19
            salarioRestante -= tramo1
        }

        if (salarioRestante > 0) {
            val tramo2 = minOf(7750.0, salarioRestante)
            irpfTotal += tramo2 * 0.24
            salarioRestante -= tramo2
        }

        if (salarioRestante > 0) {
            val tramo3 = minOf(15000.0, salarioRestante)
            irpfTotal += tramo3 * 0.30
            salarioRestante -= tramo3
        }

        if (salarioRestante > 0) {
            val tramo4 = minOf(24800.0, salarioRestante)
            irpfTotal += tramo4 * 0.37
            salarioRestante -= tramo4
        }

        if (salarioRestante > 0) {
            irpfTotal += salarioRestante * 0.45
        }
        irpf2 = String.format("%.2f", irpfTotal)
        return irpfTotal
    }

    // esta función la llamaremos en el DetailView en un método DisposableEffect()
    // efectos que requieren limpieza:
    // https://developer.android.com/develop/ui/compose/side-effects?hl=es-419#disposableeffect
//    fun clean() {
//        salario = ""
//        tipoContrato = ""
//    }
}

