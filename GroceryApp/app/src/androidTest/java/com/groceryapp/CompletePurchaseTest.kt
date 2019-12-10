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

@LargeTest
@RunWith(AndroidJUnit4::class)
class CompletePurchaseTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun completePurchaseTest() {
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

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.shipmentName),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("Gonzalo Alvarado"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.shipmentHome),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("123 utsa "), closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.shipmentCity),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("San Antonio"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.shipmentState),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("Texas"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.shipmentZip),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(replaceText("78249"), closeSoftKeyboard())

        val appCompatEditText8 = onView(
            allOf(
                withId(R.id.shipmentEmail),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatEditText8.perform(replaceText("asdsa@asdas.com"), closeSoftKeyboard())

        val appCompatEditText9 = onView(
            allOf(
                withId(R.id.shipmentPN),
                childAtPosition(
                    allOf(
                        withId(R.id.linear),
                        childAtPosition(
                            withId(R.id.coor),
                            0
                        )
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText9.perform(replaceText("9564624689"), closeSoftKeyboard())

        val appCompatRadioButton = onView(
            allOf(
                withId(R.id.cardPayment), withText("Debit or Credit"),
                childAtPosition(
                    allOf(
                        withId(R.id.paymentMethods),
                        childAtPosition(
                            withId(R.id.linear),
                            8
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatRadioButton.perform(click())

        val editText2 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.root),
                        childAtPosition(
                            withId(R.id.linear),
                            9
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        editText2.perform(replaceText("Gonzalo Alvarado"), closeSoftKeyboard())

        val editText3 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.root),
                        childAtPosition(
                            withId(R.id.linear),
                            9
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText3.perform(replaceText("4679467989788978"), closeSoftKeyboard())

        val editText4 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.root),
                        childAtPosition(
                            withId(R.id.linear),
                            9
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        editText4.perform(replaceText("125"), closeSoftKeyboard())

        val editText5 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.root),
                        childAtPosition(
                            withId(R.id.linear),
                            9
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        editText5.perform(replaceText("12/89"), closeSoftKeyboard())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.payButton), withText("Complete Payment"),
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
        appCompatButton3.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.textView), withText("We're preparing your shipment."),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("We're preparing your shipment.")))
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
