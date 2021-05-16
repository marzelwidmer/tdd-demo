package ch.keepcalm.tdd.domain.person

import ch.keepcalm.tdd.domain.DomainModelFaker
import ch.keepcalm.tdd.matcher.ValidNameMatcher
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.assertj.core.api.BDDAssertions
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import javax.validation.Validator

class PersonTest {

    private lateinit var validator: Validator

    @BeforeAll
    internal fun beforeAll() {
        val localValidatorFactoryBean = LocalValidatorFactoryBean()
        localValidatorFactoryBean.afterPropertiesSet()
        this.validator = localValidatorFactoryBean.validator
    }
    @Test
    fun `new instance with valid values should return a record`() {
        val person = DomainModelFaker.person()
        val name = person.name
        val email = person.email
        // assertj BDDAssertions
        BDDAssertions.assertThat(person).isNotNull
        BDDAssertions.then(person.name).isEqualToIgnoringCase(name)
        // kotest
        person.email shouldBeEqualComparingTo email
    }

    @Test
    fun `new instance with invalid contains should produce contains violations`() {
        val person = DomainModelFaker.person(name= "j", email= "noValidEmailAddress")
        val constrainViolations = validator.validate(person)
        BDDAssertions.then(constrainViolations.size).isEqualTo(2)
    }

    @Test
    fun `Matcher test` () {
        val person = DomainModelFaker.person()
        assertThat(person.name, ValidNameMatcher())
    }

    @Test
    fun `Should throw AssertionError because of invalid name` () {
        Assertions.assertThrows(AssertionError::class.java) {
            val person = DomainModelFaker.person(name = "foo")
            assertThat(person.name, ValidNameMatcher())
        }
    }
}


