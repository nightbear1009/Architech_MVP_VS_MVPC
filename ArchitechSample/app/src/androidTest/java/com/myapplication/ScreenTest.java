package com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ScreenTest {
    @Rule
    public ActivityTestRule<MainActivity> mTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);
    @Test
    public void testApiSuccess() throws Exception {
        // Context of the app under test.
        Injection.init(true);
        mTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn)).perform(click());
        onView(withText(containsString("api success"))).check(matches(isDisplayed()));
    }

    @Test
    public void testApiFailed() throws Exception {
        // Context of the app under test.
        Injection.init(false);
        mTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn)).perform(click());
        onView(withText(containsString("api failed"))).check(matches(isDisplayed()));
    }
}
