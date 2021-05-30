@file:Suppress("NonAsciiCharacters")

package ch.keepcalm.tdd.api

import ch.keepcalm.tdd.domain.person.model.Person
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.hateoas.MediaTypes
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@WebFluxTest
class PersonApiTest(private val client: WebTestClient) {

    @Test
    fun `Should return a Bad Request when validation fails`() {
        val person = Person(name = "J", email = "john@doe.com")

        client.post()
            .uri("/person")
            .contentType(MediaType.APPLICATION_JSON)
            .accept().header(MediaTypes.HAL_JSON_VALUE)
            .body(Mono.just(person), Person::class.java)
            .exchange()
            .expectStatus().isBadRequest
//        client.get()
//            .uri { uriBuilder ->
//                uriBuilder
//                    .path("/personWithValidation")
//                    .queryParam("name", "J")
//                    .build()
//            }
//            .exchange()
//            .expectStatus().isBadRequest
    }

    @Test
    fun `Should return a status of 2xx for the API person resource and a person representation`() {
        client.get()
            .uri("/person")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody()
            .jsonPath("$.name").isNotEmpty
    }

    @Test
    fun `Create a person with POST returns person representation`() {
        val person = Person(name = "John", email = "john@doe.com")

        client.post()
            .uri("/person")
            .contentType(MediaType.APPLICATION_JSON)
            .accept().header(MediaTypes.HAL_JSON_VALUE)
            .body(Mono.just(person), Person::class.java)
            .exchange()
            .expectStatus().isCreated
            .expectHeader().contentType(MediaTypes.HAL_JSON_VALUE)
            .expectBody()
            .jsonPath("$.name").isNotEmpty()
            .jsonPath("$.name").isEqualTo("John")

    }

}
