package com.cursoandroid.doglist

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursoandroid.doglist.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImagenes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        binding.svPerros.setOnQueryTextListener(this)
        
        initRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun initRecyclerView() {
        // no puedo inicializar aquí el adapter porque aún no tenemos las imágenes que vamos a mostrar
        // por eso arriba hemos creado una mutableList, que aunque esté vacía se la podemos pasar
        // al adapter y así se inicie con algo:
        adapter = DogAdapter(dogImagenes)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create()) // convertirá la respuesta del json a nuestro objeto DogResponse
            .build()
    }

    private fun buscarPorNombre(query: String) {
        // creamos una corrutina para que tpdo lo que se llame aquí se ejecute en el hilo secunddario
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = getRetrofit().create(APIService::class.java).getPerrosPorRaza("$query/images")
            // llamada nos devuelve un response no el objeto que queremos (DogResponse)
            val perritos = llamada.body()  // el body es donde está la respuesta
            runOnUiThread {
                if(llamada.isSuccessful) {
                    // mostrar el recyclerView
                    val imagenes = perritos?.imagenes ?: emptyList()
                    dogImagenes.clear()
                    dogImagenes.addAll(imagenes)
                    adapter.notifyDataSetChanged()
                }else {
                    //mostrar error
                    mostrarError()
                }
                ocultarTeclado()
            }
        }
    } // fin funcion buscarPorNombre

    private fun ocultarTeclado() {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.main.windowToken, 0)
    }

    private fun mostrarError() {
        Toast.makeText(this, "ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
       if(!query.isNullOrEmpty()) {
           buscarPorNombre(query.lowercase())
       }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}