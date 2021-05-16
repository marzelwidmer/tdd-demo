package ch.keepcalm.tdd.matcher

import org.hamcrest.BaseMatcher
import org.hamcrest.Description

// Custom Matcher
class ValidNameMatcher : BaseMatcher<String>(){
    private fun isValidName(name: String) : Boolean = name[0].isUpperCase()

    override fun describeTo(description: Description?) {
        description?.appendText("the name must start with a uppercase letter")
    }

    override fun matches(actual: Any?): Boolean {
        return actual is String && isValidName(actual)
    }
}
