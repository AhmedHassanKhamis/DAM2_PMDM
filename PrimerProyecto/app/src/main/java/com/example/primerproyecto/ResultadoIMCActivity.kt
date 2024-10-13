package com.example.primerproyecto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.primerproyecto.databinding.ActivityResultadoImcBinding
import com.example.primerproyecto.databinding.ActivityImcCalculatorBinding

class ResultadoIMCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imcResult = intent.getFloatExtra("IMC_RESULT", 0.0f)
        binding.imcResultTextView.text = imcResult.toString()
    }
}

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up listeners and logic for calculating IMC
        binding.calculateButton.setOnClickListener {
            val height = binding.heightSlider.value
            val weight = binding.weightValue.text.toString().toFloat()
            val imc = weight / ((height / 100) * (height / 100))

            val intent = Intent(this, ResultadoIMCActivity::class.java).apply {
                putExtra("IMC_RESULT", imc)
            }
            startActivity(intent)
        }
    }
}