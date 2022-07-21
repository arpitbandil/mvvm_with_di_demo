package com.demo.virginmoneydemo.ui

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.demo.virginmoneydemo.R
import com.demo.virginmoneydemo.models.People
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

@HiltAndroidTest
class PeopleDetailFragmentTest {
    val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityTestRule(HomeActivity::class.java)

    @get:Rule
    val rule = RuleChain.outerRule(hiltRule).around(activityTestRule)

    @Before
    fun jumpToPeopleDetailFragment() {
        val people = People(
            "https://randomuser.me/api/portraits/women/21.jpg",
            "2022-01-24T17:02:23.729Z",
            "Nicolas61@hotmail.com",
            "pink",
            "Maggie",
            "1",
            "Future Functionality Strategist",
            "Brekke"
        )
        activityTestRule.activity.apply {
            runOnUiThread {
                val bundle = Bundle().apply { putParcelable("people", people) }
                findNavController(R.id.nav_host).navigate(R.id.peopleDetailFragment, bundle)
            }
        }
    }

    @Test
    fun checkDataDisplayed() {
        onView(withId(R.id.tv_full_name)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_image)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_job_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_email)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_color)).check(matches(isDisplayed()))
    }

    @Test
    fun isBackWorking() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        onView(
            allOf(
                instanceOf(AppCompatImageButton::class.java),
                withParent(withId(R.id.toolbar))
            )
        ).perform(click())
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))
    }
}
