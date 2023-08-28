package com.example.textcomparator.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.textcomparator.databinding.ActivityMainBinding
import com.example.textcomparator.model.Comparador

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            // Crea un objeto Comparer
            val comparer = Comparador(text1, text2)

            // Pásaselo al ViewModel
            mainViewModel.setComparer(comparer)

            // Observa el resultado de la comparación
            mainViewModel.result.observe(this) { result ->
                binding.resultTextView.text = result
            }
        }
    }
}