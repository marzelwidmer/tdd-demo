package ch.keepcalm.tdd.domain.address

import ch.keepcalm.tdd.domain.DomainModelFaker
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldNotBeNull
import org.junit.jupiter.api.Test

class AddressTests {

    @Test
    fun `Should create an Address instance`() {
        val address = DomainModelFaker.address()
        address.shouldNotBeNull()
    }

    @Test
    fun `Should create a new instance with valid values`() {
        val address = DomainModelFaker.address()
        val street = address.street
        val streetNr = address.streetNr
        val zip = address.zip
        val city = address.city
        val province = address.province
        val provinceCode = address.provinceCode

        address.street `should be equal to` street
        address.streetNr `should be equal to` streetNr
        address.zip `should be equal to` zip
        address.city `should be equal to` city
        address.province `should be equal to` province
        address.provinceCode `should be equal to` provinceCode

    }
}
