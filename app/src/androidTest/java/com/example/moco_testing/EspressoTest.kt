package com.example.moco_testing


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class EspressoTest {

    @Rule
    @JvmField
    val activityRule : ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun listehinzuegen(){

        onView(withId(R.id.PKWrecyclerView))
            .perform(swipeLeft())

        onView(withId(R.id.TextFeldModell))
            .perform(replaceText("MoCo2020"))
            .check(matches(withText("MoCo2020")))

        onView(withId(R.id.textFeldHersteller))
            .perform(replaceText("Th-Köln"))
            .check(matches(withText("Th-Köln")))

        onView(withId(R.id.textFeldVerbauch))
            .perform(replaceText("12"))
            .check(matches(withText("12")))

        onView(withId(R.id.textFeldPS))
            .perform(replaceText("230"))
            .check(matches(withText("230")))

        onView(withText("SUBMIT"))
            .perform(click())

        onView(withText("LISTE"))
            .perform(click())

        onView(withId(R.id.ButtonRe))
            .perform(click())

        onView(withId(R.id.row_ps))
            .check(matches(withText("PS: 230")))
    }
}



