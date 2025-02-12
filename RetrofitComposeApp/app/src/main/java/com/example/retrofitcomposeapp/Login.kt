package com.example.retrofitcomposeapp

class Login {
    fun log(mensaje: String) {
        print("Log $mensaje")
    }
}

class ClaseConInstancia {
    private val login = Login()

    fun myFun() {
        login.log("hacer cosas desde instancia...")
    }
}
class ClaseConInstancia2 {
    private val login = Login()

    fun myFun() {
        login.log("hacer cosas desde instancia2...")
    }
}
class ClaseConInstancia3 {
    private val login = Login()

    fun myFun() {
        login.log("hacer cosas desde instancia3...")
    }
}

class ClaseConInyeccionDeDependencias(private val login: Login) {
    fun myFun() {
        login.log("mensaje desde clase inyectada....")
    }
}

