package kmitl.playstory.pattasing.playstory.controller;


import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import kmitl.playstory.pattasing.playstory.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        onView(allOf(withId(R.id.login_button))).perform(click());
        SystemClock.sleep(5000);
        onView(withText("My Story")).check(matches(isDisplayed()));
    }

    @Test
    public void cancelAdd(){
        onView(withId(R.id.imageAdd)).perform(click());
        onView(withText("Add Your Time Story")).check(matches(isDisplayed()));
        onView(withId(R.id.imageInAddIcon)).perform(click());
        pressBack();
        onView(withId(R.id.imageIconAdd)).perform(click());
        onView(withText("Add Your Time Story")).check(matches(isDisplayed()));
        onView(withId(R.id.editTextMessage)).perform(replaceText("Test"), closeSoftKeyboard());
        onView(withId(R.id.imageAddIconTime)).perform(click());
        pressBack();
        onView(withId(R.id.textCancelTime)).perform(click());
        onView(withId(R.id.textCancelDate)).perform(click());
    }

}
