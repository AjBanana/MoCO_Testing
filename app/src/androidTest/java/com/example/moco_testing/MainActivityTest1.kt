package com.example.moco_testing



import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
@LargeTest
class MainActivityTest1 {

    @Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest1() {


        val liste = onView(
            withContentDescription("Liste"),
        )

        val recyclerView = onView(withId(R.id.PKWrecyclerView))
        recyclerView.perform(swipeLeft())

        var i =1
        repeat(3) {
            addtoList(i)
            i++
        }
        Espresso.closeSoftKeyboard()

        liste.perform(click())

        recyclerView.perform(swipeUp())

        onView(
            allOf(
                withId(R.id.VerbrauchKosten), withText("Kosten auf 100Km 13.0€"),
                withParent(
                    allOf(
                        withId(R.id.car_row),
                        withParent(withId(R.id.PKWrecyclerView))
                    )
                ),
            )
        ).check(matches(isDisplayed()))


    //   onView(withId(R.id.ButtonRe)).check(matches(withText(containsString("test"))))




    }

    fun addtoList(i: Int){
        onView(withId(R.id.TextFeldModell)).perform(replaceText("Auto"))
        onView(withId(R.id.textFeldHersteller)).perform(replaceText("TH-Köln"))
        onView(withId(R.id.textFeldVerbauch)).perform(clearText()).perform(typeText((10+i).toString()))
        onView(withId(R.id.textFeldPS)).perform(clearText()).perform(typeText((3+i).toString()))
        onView(withId(R.id.buttonSubmit)).perform(click())



        }



    }

