package ch.keepcalm.tdd

import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.assertj.core.api.BDDAssertions
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import java.util.*
import javax.validation.Validator

class PersonTest {

    private lateinit var validator: Validator

    @BeforeAll
    fun setup(){
        val localValidatorFactoryBean = LocalValidatorFactoryBean()
        localValidatorFactoryBean.afterPropertiesSet()
         this.validator = localValidatorFactoryBean.validator
    }

    @Test
    fun `new instance with valid values should return a record`() {
        val person = Person(id = UUID.randomUUID(), name = "John", email= "john@doe.ch")
        // assertj BDDAssertions
        BDDAssertions.assertThat(person.id).isNotNull
        BDDAssertions.then(person.name).isEqualToIgnoringCase("John")
        // kotest
        person.email shouldBeEqualComparingTo "john@doe.ch"
    }

    @Test
    fun `new instance with invalid contains should produce contains violations`() {
        val person = Person(id = UUID.randomUUID(), name = "J", email= "noValidEmailAddres")
        val constrainViolations = validator.validate(person)
        BDDAssertions.then(constrainViolations.size).isEqualTo(2)
    }

    @Test
    fun `Matcher test` () {
        val person = Person(id = UUID.randomUUID(), name = "John", email= "john@doe.ch")
        assertThat(person.name, ValidNameMatcher())
    }
}

// Custom Matcher
class ValidNameMatcher : BaseMatcher<String> (){
    private fun isValidName(name: String) : Boolean = name[0].isUpperCase()

    override fun describeTo(description: Description?) {
        description?.appendText("the name must start with a uppercase letter")
    }

    override fun matches(actual: Any?): Boolean {
         return actual is String && isValidName(actual)
    }

}

