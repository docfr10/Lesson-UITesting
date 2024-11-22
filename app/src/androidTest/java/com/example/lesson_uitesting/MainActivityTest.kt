package com.example.lesson_uitesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
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

    // Правило, которое запускает MainActivity перед каждым тестом
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Подготовка перед каждым тестом (если необходимо)
    }

    @After
    fun tearDown() {
        // Действия после каждого теста (если необходимо)
    }

    @Test
    fun testInitialViewVisibility() {
        // Проверяем, что TextView отображается при запуске
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        // Проверяем, что кнопка "Change Text" отображается при запуске
        onView(withId(R.id.changeTextButton)).check(matches(isDisplayed()))
        // Проверяем, что кнопка "Change fragment" отображается при запуске
        onView(withId(R.id.changeFragmentButton)).check(matches(isDisplayed()))
        // Проверяем, что EditText отображается при запуске
        onView(withId(R.id.editText)).check(matches(isDisplayed()))
    }

    @Test
    fun testTextChange() {
        // Вводим текст в EditText
        onView(withId(R.id.editText)).perform(typeText("Hello, World!"), closeSoftKeyboard())
        // Нажимаем на кнопку для изменения текста
        onView(withId(R.id.changeTextButton)).perform(click())
        // Проверяем, что TextView изменил текст на введенный
        onView(withId(R.id.textView)).check(matches(withText("Hello, World!")))
    }

    @Test
    fun testEmptyInput() {
        // Очищаем EditText (если там был текст)
        onView(withId(R.id.editText)).perform(clearText(), closeSoftKeyboard())
        // Нажимаем на кнопку изменения текста
        onView(withId(R.id.changeTextButton)).perform(click())
        // Проверяем, что TextView содержит пустую строку
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun testLongTextInput() {
        // Вводим длинный текст в EditText
        val longText =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        onView(withId(R.id.editText)).perform(typeText(longText), closeSoftKeyboard())
        // Нажимаем на кнопку изменения текста
        onView(withId(R.id.changeTextButton)).perform(click())
        // Проверяем, что TextView отображает длинный текст
        onView(withId(R.id.textView)).check(matches(withText(longText)))
    }

    @Test
    fun testSpecialCharactersInput() {
        // Вводим текст с особыми символами в EditText
        val specialText = "!@#$%^&*()_+-=[]{}|;':\",./<>?"
        onView(withId(R.id.editText)).perform(typeText(specialText), closeSoftKeyboard())
        // Нажимаем на кнопку изменения текста
        onView(withId(R.id.changeTextButton)).perform(click())
        // Проверяем, что TextView отображает текст с особыми символами
        onView(withId(R.id.textView)).check(matches(withText(specialText)))
    }

    @Test
    fun testTextChangeWithoutClosingKeyboard() {
        // Вводим текст в EditText без закрытия клавиатуры
        onView(withId(R.id.editText)).perform(typeText("Test without closing keyboard"))
        // Нажимаем на кнопку изменения текста
        onView(withId(R.id.changeTextButton)).perform(click())
        // Проверяем, что TextView изменил текст на введенный
        onView(withId(R.id.textView)).check(matches(withText("Test without closing keyboard")))
    }
}