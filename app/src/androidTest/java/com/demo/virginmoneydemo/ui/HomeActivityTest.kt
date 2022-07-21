package com.demo.virginmoneydemo.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.demo.virginmoneydemo.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

@HiltAndroidTest
class HomeActivityTest {

    val hiltRule = HiltAndroidRule(this)
    private val activityTestRule = ActivityTestRule(HomeActivity::class.java)

    @get:Rule
    val rule = RuleChain.outerRule(hiltRule).around(activityTestRule)

    @Test
    fun loadingDisplayTest() {
        onView(withId(R.id.progress_circular)).check(matches(isDisplayed()))
    }

    @Test
    fun isDataDisplaying() {
        Thread.sleep(15000)
        onView(withId(R.id.people_list)).check(matches(isDisplayed()))
    }

    @Test
    fun isRoomDataLoaded() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        Thread.sleep(5000)
        onView(withId(R.id.rooms_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkForLoadingAfterReSwipe() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        Thread.sleep(10000)
        onView(withId(R.id.view_pager)).perform(swipeRight())
        onView(withId(R.id.people_list)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPeopleItemClick() {
        Thread.sleep(15000)
        onView(withId(R.id.people_list))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.detail_image)).check(matches(isDisplayed()))
    }
}
