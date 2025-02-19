package com.cursoandroid.retrofitcomposeapp

class Login {
    fun log(mensaje: String) {
        println("Log $mensaje")
    }
}

class ClaseConInstancia {
    private val login = Login()

    fun myFun() {
        login.log("hacer algo...")
    }
}

// imaginemeos que tenemos muchas clases que siempre instancian a la clase Login:

class ClaseConInstancia2 {
    private val login = Login()

    fun myFun() {
        login.log("hacer algo...")
    }
}


class ClaseConInyeccionDeDependencias(private val login: Login) {
    fun myFun() {
        login.log("haciendo algo más...")
    }
}