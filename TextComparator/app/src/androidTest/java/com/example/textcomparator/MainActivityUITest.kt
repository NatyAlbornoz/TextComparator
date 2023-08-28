package com.example.textcomparator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.textcomparator.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testTextosIguales() {
        // Ingresa texto en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hola"))

        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("Hola"))

        // Presiona el botón
        Espresso.onView(ViewMatchers.withId(R.id.compareButton))
            .perform(ViewActions.click())

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Los textos son iguales")))
    }

    @Test
    fun testTextosDiferentes() {
        // Ingresa texto en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hola"))

        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("Mundo"))

        // Presiona el botón
        Espresso.onView(ViewMatchers.withId(R.id.compareButton))
            .perform(ViewActions.click())

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Los textos son diferentes")))
    }
}