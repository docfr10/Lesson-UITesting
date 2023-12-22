package com.example.lesson_uitesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {
        // Проверка видимости
        onView(withId(R.id.textView)).check(matches(isDisplayed()))

        // Проверка видимости
        onView(withId(R.id.changeTextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testFragment() {
        // Нажатие на кнопку
        onView(withId(R.id.changeFragmentButton)).perform(click())

        // Проверка видимости
        onView(withId(R.id.fragment)).check(matches(isDisplayed()))
    }

    @Test
    fun textTest() {
        // Ввод значения в EditText
        onView(withId(R.id.editText)).perform(typeText("Hello, World!"), closeSoftKeyboard())

        // Нажатие на кнопку
        onView(withId(R.id.changeTextButton)).perform(click())

        // Проверка текста
        onView(withId(R.id.textView)).check(matches(withText("Hello, World!")))
    }
}