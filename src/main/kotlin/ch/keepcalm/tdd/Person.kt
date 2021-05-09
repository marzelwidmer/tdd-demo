package ch.keepcalm.tdd

import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class Person(
    val id: UUID,
    @get:Size(min = 2, max = 15) val name: String,
    @get:Email val email: String
)
