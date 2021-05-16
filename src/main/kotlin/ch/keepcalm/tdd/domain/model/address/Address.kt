package ch.keepcalm.tdd.domain.model.address

data class Address(
    val street: String? = "",
    val streetNr: String? = "",
    val zip: String? = "",
    val city: String? = "",
    val province: String? = "",
    val provinceCode: String? = ""
)



