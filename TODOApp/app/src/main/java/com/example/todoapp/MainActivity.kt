package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.TareasCategorias.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private  val categorias = listOf(
        Negocio,
        Personal,
        Otros
    )
    private  val tareas = mutableListOf(
        Tarea("Prueba negocio", Negocio),
        Tarea("Prueba otros", Otros),
        Tarea("Prueba personal", Personal)
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var categoriasAdapter: CategoriasAdapter
    private lateinit var rvTareas:RecyclerView
    private lateinit var tareasAdapter: TareasAdapter
    private lateinit var fabAddTask:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponent()
        initUI()
        initListener()
    }

    private fun initListener() {
        fabAddTask.setOnClickListener{
            mostrarDialogo()
        }
    }

    private fun mostrarDialogo() {
        val dialogo = Dialog(this)
        dialogo.setContentView(R.layout.dialogo_tarea)

        // para acceder a los componentes de la pantalla dialogo hay que acceder primero a el:
        val btnAgregarTarea: Button = dialogo.findViewById(R.id.btnAgregarTarea)
        val etTarea: EditText = dialogo.findViewById(R.id.etTarea)
        val rgCategorias: RadioGroup = dialogo.findViewById(R.id.rgCategorias)
        btnAgregarTarea.setOnClickListener{

            val tareaActual = etTarea.text.toString()
            val selectId = rgCategorias.checkedRadioButtonId

            val selectedRadioButton: RadioButton = rgCategorias.findViewById(selectId)

            

        }
        dialogo.show()
    }

    private fun initUI() {
        categoriasAdapter = CategoriasAdapter(categorias)
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = categoriasAdapter

        tareasAdapter= TareasAdapter(tareas)
        rvTareas.layoutManager=LinearLayoutManager(this)
        rvTareas.adapter=tareasAdapter

    }

    private fun initComponent() {
        rvCategorias = findViewById(R.id.rvCategorias)
        rvTareas= findViewById(R.id.rvTareas)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun onItemSelected(position: Int){
        tareas[position].isSelected = !
    }
}