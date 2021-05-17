package ch.keepcalm.tdd.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient


@WebFluxTest
class PersonApiTest (@Autowired private val client: WebTestClient) {

    @Test
    fun index() {
        client.get()
            .uri("/")
            .exchange()
            .expectStatus()
            .is2xxSuccessful
            .expectBody()
    }

    @Test
    fun `error 🦠` () {
        client.get().uri("/wrong/endpoint").exchange().expectStatus().is4xxClientError
    }
}
