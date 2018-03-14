package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.anything;

/**
 * Created by agagne on 13/03/18.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
                .check(matches(withText("Business Name")));
    }

    @Test
    public void bReadContact() throws Exception {
        mActivity.getActivity();

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .perform(click());
        onView(withId(R.id.name)).check(matches(withText("Business Name")));
        onView(withId(R.id.number)).check(matches(withText("123 456-7890")));
        onView(withId(R.id.business)).check(matches(withText("Fish Monger")));
        onView(withId(R.id.address)).check(matches(withText("00 Anywhere")));
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }

    @Test
    public void cUpdateContact() throws Exception {
        mActivity.getActivity();

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .perform(click());
        onView(withId(R.id.name)).perform(clearText())
                .perform(typeText("New Name"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.number)).perform(clearText())
                .perform(typeText("456-235 3854"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.business)).perform(clearText())
                .perform(typeText("Distributor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.address)).perform(clearText());
        onView(withId(R.id.province)).perform(clearText());
        onView(withId(R.id.updateButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .check(matches(withText("New Name")));
    }

    @Test
    public void deleteContact() throws Exception {
        mActivity.getActivity();

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0)
                .perform(click());
        onView(withId(R.id.deleteButton)).perform(click());

        onView(withId(R.id.listView))
                .check(matches(not(hasDescendant(withText("New Name")))));
    }
}