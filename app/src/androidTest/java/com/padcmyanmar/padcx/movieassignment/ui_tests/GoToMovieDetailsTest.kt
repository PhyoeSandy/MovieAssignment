package com.padcmyanmar.padcx.movieassignment.ui_tests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.padcmyanmar.padcx.movieassignment.R
import com.padcmyanmar.padcx.movieassignment.activities.MainActivity
import com.padcmyanmar.padcx.movieassignment.views.viewholders.SmallMoviesViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Phyoe Sandy Soe Tun
 * on 8/5/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailsTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToMovieDetails() {
        onView(withId(R.id.rvPopularMovies))
            .perform(RecyclerViewActions.actionOnItemAtPosition<SmallMoviesViewHolder>(0, click()))

        onView(withId(R.id.tvDescription))
            .check(matches(isDisplayed()))
    }
}