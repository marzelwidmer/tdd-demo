package ch.keepcalm.tdd

import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.assertj.core.api.BDDAssertions
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
    fun `new instance with invalid valid contrains should produce contrains violations`() {
        val person = Person(id = UUID.randomUUID(), name = "J", email= "noValidEmailAddres")
        val constrainViolations = validator.validate(person)
        BDDAssertions.then(constrainViolations.size).isEqualTo(2)
    }
}
