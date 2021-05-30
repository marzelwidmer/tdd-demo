package ch.keepcalm.tdd.domain.api

import ch.keepcalm.tdd.domain.person.model.Person
import org.springframework.hateoas.MediaTypes
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.support.WebStack
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(produces = [MediaTypes.HAL_JSON_VALUE])
@EnableHypermediaSupport(stacks = [WebStack.WEBFLUX], type = [EnableHypermediaSupport.HypermediaType.HAL])
class PersonResource() {

    @GetMapping(value = ["/person"])
    suspend fun getPerson() = Person(name = "John", email = "john@doe.com")

    @PostMapping(value = ["/person"])
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun postPerson(@RequestBody @Valid person: Person): Person {
        return person
    }
}
