package com.lessthanthree.anything

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadFeature() {
        onView(withId(R.id.rvHome)).check(matches(isDisplayed()))
        onView(withId(R.id.rvHome)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
    }

    @Test
    fun assertIncreaseCounter() {
        val expected = 1
        onView(withId(R.id.rvHome)).perform(RecyclerViewActions.
        actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        onView(withId(R.id.btnPlus)).check(matches(isDisplayed()))
        onView(withId(R.id.btnPlus)).perform(click())
        onView(withId(R.id.textViewCount)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewCount)).check(matches(withText(expected.toString())))
    }

    @Test
    fun assertDecreaseCounter() {
        val expected = 0
        onView(withId(R.id.rvHome)).perform(RecyclerViewActions.
        actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        onView(withId(R.id.btnMinus)).check(matches(isDisplayed()))
        onView(withId(R.id.btnMinus)).perform(click())
        onView(withId(R.id.textViewCount)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewCount)).check(matches(withText(expected.toString())))
    }

    @Test
    fun assertResetCounter() {
        val expected = 0
        onView(withId(R.id.rvHome)).perform(RecyclerViewActions.
        actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
        onView(withId(R.id.btnReset)).check(matches(isDisplayed()))
        onView(withId(R.id.btnReset)).perform(click())
        onView(withId(R.id.textViewCount)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewCount)).check(matches(withText(expected.toString())))
    }

}