package ch.keepcalm.tdd.domain.person.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class Person(
    @field:NotEmpty @field:Size(min= 2, message = "Invalid field")
    var name: String,
    @field:Email
    val email: String
)
