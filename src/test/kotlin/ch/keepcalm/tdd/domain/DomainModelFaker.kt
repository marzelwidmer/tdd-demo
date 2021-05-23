package ch.keepcalm.tdd.domain

import ch.keepcalm.tdd.domain.address.model.*
import ch.keepcalm.tdd.domain.person.model.Person

class DomainModelFaker {

    companion object {
        //        fun person(name: String = Faker().name.firstName(), email: String = Faker().internet.safeEmail()): Person = Person(
//            name = name,
//            email = email
//        )
//        fun address(): Address = Address(
//            street = Street(Faker().address.streetName()),
//            streetNr = StreetNr(Faker().address.buildingNumber()),
//            zip = Zip(Faker().address.postcode()),
//            city = City(Faker().address.city()),
//            province = Province(Faker().address.cityWithState()),
//            provinceCode = ProvinceCode(Faker().address.postcode())
//        )
        fun person(name: String = "John", email: String = "john@doe.com"): Person = Person(
            name = name,
            email = email
        )

        fun address(): Address = Address(
            street = Street("street"),
            streetNr = StreetNr("strNr123"),
            zip = Zip("8009"),
            city = City("Zuerich"),
            province = Province("Zuerich"),
            provinceCode = ProvinceCode("ZH")
        )
    }
}

