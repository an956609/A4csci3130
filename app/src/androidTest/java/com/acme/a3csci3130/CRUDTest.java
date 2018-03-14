package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.anything;

/**
 * Created by agagne on 13/03/18.
 */
@RunWith(AndroidJUnit4.class)
public class CRUDTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivity =
            new ActivityTestRule<MainActivity>(MainActivity.class);
    @Test
    public void addContact() throws Exception {
        mActivity.getActivity();

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("Business Name"));
        onView(withId(R.id.number)).perform(typeText("123 456-7890"));
        onView(withId(R.id.business)).perform(typeText("Fish Monger"));
        onView(withId(R.id.address)).perform(typeText("00 Anywhere"));
        onView(withId(R.id.province)).perform(typeText("AB"));
        onView(withId(R.id.submitButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .onChildView(withId(android.R.id.text1))
                .check(matches(withText("Business Name")));
    }

    @Test
    public void readContact() throws Exception {
        mActivity.getActivity();

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .perform(click());

    }

    @Test
    public void updateContact() throws Exception {

    }

    @Test
    public void deleteContact() throws Exception {

    }
}