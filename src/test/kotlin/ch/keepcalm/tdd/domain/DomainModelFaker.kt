package ch.keepcalm.tdd.domain

import ch.keepcalm.tdd.domain.address.model.*
import ch.keepcalm.tdd.domain.person.model.Person
import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.FakerConfig
import io.github.serpro69.kfaker.create

class DomainModelFaker {

    companion object {
        private val limit40 = Faker(FakerConfig.builder().create() { this.uniqueGeneratorRetryLimit = 40 })
        private val limit20 = Faker(FakerConfig.builder().create() { this.uniqueGeneratorRetryLimit = 20 })

        fun person(name: String = Faker().name.firstName(), email: String = Faker().internet.safeEmail()): Person = Person(
            name = name,
            email = email
        )


        fun address(): Address = Address(
            street = Street(limit40.address.streetName()),
            streetNr = StreetNr(limit40.address.buildingNumber()),
            zip = Zip(limit20.address.postcode()),
            city = City(limit40.address.city()),
            province = Province(limit40.address.cityWithState()),
            provinceCode = ProvinceCode(limit20.address.postcode())
        )

    }
}

