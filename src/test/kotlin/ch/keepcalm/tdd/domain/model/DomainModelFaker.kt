package ch.keepcalm.tdd.domain.model

import ch.keepcalm.tdd.domain.model.address.Address
import ch.keepcalm.tdd.domain.model.person.Person
import io.github.serpro69.kfaker.Faker

class DomainModelFaker {
    companion object {
        fun person(name: String = Faker().name.firstName(), email: String = Faker().internet.safeEmail()): Person = Person(
            name = name,
            email = email
        )

        fun address(): Address = Address(
            street = Faker().address.streetName(),
            streetNr = Faker().address.buildingNumber(),
            zip = Faker().address.postcode(),
            city = Faker().address.city(),
            province = Faker().address.cityWithState(),
            provinceCode = Faker().address.postcode()
        )
    }
}

