package ch.keepcalm.tdd.domain

import ch.keepcalm.tdd.domain.address.model.*
import ch.keepcalm.tdd.domain.person.model.Person
import com.github.javafaker.Faker

class DomainModelFaker {
    companion object {
        private val  faker = Faker()
        fun person(name: String = faker.name().firstName(), email: String = faker.internet().emailAddress()): Person = Person(
            name = name,
            email = email
        )

        fun address(): Address = Address(
            street = Street(faker.address().streetAddress()),
            streetNr = StreetNr(faker.address().streetAddressNumber()),
            zip = Zip(faker.address().zipCode()),
            city = City(faker.address().city()),
            province = Province(faker.address().state()),
            provinceCode = ProvinceCode(faker.address().cityPrefix())
        )
    }
}

