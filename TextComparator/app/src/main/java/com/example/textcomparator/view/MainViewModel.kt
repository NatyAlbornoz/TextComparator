package com.example.textcomparator.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.textcomparator.model.Comparador

class MainViewModel : ViewModel() {

    private val _comparador = MutableLiveData<Comparador>()
    val comparador: LiveData<Comparador> get() = _comparador

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun setComparer(comparer: Comparador) {
        _comparador.value = comparer

        // Compara los textos
        compareTexts()
    }

    // Lógica para comparar los textos
    fun compareTexts() {
        val text1 = comparador.value?.text1
        val text2 = comparador.value?.text2

        if (text1 == text2) {
            _result.value = "Los textos son iguales"
        } else {
            _result.value = "Los textos son diferentes"
        }
    }
}