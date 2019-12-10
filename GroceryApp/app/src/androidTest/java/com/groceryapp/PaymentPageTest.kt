package com.groceryapp


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
Checks if Payment Page is reached
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class PaymentPageTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun paymentPageTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.usernameText),
                childAtPosition(
                    allOf(
                        withId(R.id.include),
                        childAtPosition(
                            withClassName(`is`("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("nezuko"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.passwordText),
                childAtPosition(
                    allOf(
                        withId(R.id.include),
                        childAtPosition(
                            withClassName(`is`("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("buckets"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.loginButton), withText("Log In"),
                childAtPosition(
                    allOf(
                        withId(R.id.include),
                        childAtPosition(
                            withClassName(`is`("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val editText = onView(
            allOf(
                withId(R.id.qtyBox),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.productList),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        editText.perform(replaceText("1"), closeSoftKeyboard())

        val button = onView(
            allOf(
                withId(R.id.addButton), withText("Add"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.productList),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        button.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.cartFab),
                childAtPosition(
                    allOf(
                        withId(R.id.coordinatorLayout),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.checkButton), withText("Proceed to checkout"),
                childAtPosition(
                    allOf(
                        withId(R.id.coordinatorLayout2),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val button2 = onView(
            allOf(
                withId(R.id.payButton),
                childAtPosition(
                    allOf(
                        withId(R.id.coor),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
