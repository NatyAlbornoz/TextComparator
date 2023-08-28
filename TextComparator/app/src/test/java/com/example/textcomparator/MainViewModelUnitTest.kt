package com.example.textcomparator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.textcomparator.model.Comparador
import com.example.textcomparator.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun compareTexts_Equal() {
        val comparer = Comparador("Hola", "Hola")
        viewModel.setComparer(comparer)

        val result = viewModel.result.value

        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun compareTexts_Different() {
        val comparer = Comparador("Hola", "Mundo")
        viewModel.setComparer(comparer)

        val result = viewModel.result.value

        assertEquals("Los textos son diferentes", result)
    }
}