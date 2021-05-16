package ch.keepcalm.tdd.domain.person.model

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class Person(
    @get:Size(min = 2, max = 15) val name: String,
    @get:Email val email: String
)
