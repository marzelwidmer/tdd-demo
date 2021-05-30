package ch.keepcalm.tdd.domain.api

import ch.keepcalm.tdd.domain.person.model.Person
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.MediaTypes
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder
import org.springframework.hateoas.support.WebStack
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(produces = [MediaTypes.HAL_JSON_VALUE])
@EnableHypermediaSupport(stacks = [WebStack.WEBFLUX], type = [EnableHypermediaSupport.HypermediaType.HAL])
class IndexResource() {
    companion object REL {
        const val REL_SPRING_INITIALIZR = "start-spring"
    }

    @GetMapping("/")
    suspend fun index(): EntityModel<Unit> {
        return EntityModel.of(Unit, WebFluxLinkBuilder.linkTo(WebFluxLinkBuilder.methodOn(IndexResource::class.java).index()).withSelfRel().toMono().awaitSingle())
            .add(Link.of("http://start.spring.io").withRel(REL_SPRING_INITIALIZR))
    }


    @GetMapping(value = ["/person"])
    suspend fun getPerson(@RequestParam @Validated name: String) = Person(name=name, email = "foo@bar.com")

    @PostMapping(value = ["/person"])
    suspend fun postPerson(@RequestBody @Validated person: Person): Person {
        return person
    }
}
