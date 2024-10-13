package com.example.primerproyecto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.primerproyecto.databinding.ActivityImcCalculatorBinding

class imcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            val intent = Intent(this, ResultadoIMCActivity::class.java)
            // Pass data to the next activity
            startActivity(intent)
        }
    }
}