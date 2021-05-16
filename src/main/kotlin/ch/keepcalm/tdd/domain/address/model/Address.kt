package ch.keepcalm.tdd.domain.address.model

data class Address(
    val street: Street? = Street(),
    val streetNr: StreetNr? = StreetNr(),
    val zip: Zip? = Zip(),
    val city: City? = City(),
    val province: Province? = Province(),
    val provinceCode: ProvinceCode? = ProvinceCode()
)
