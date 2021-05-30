@file:Suppress("NonAsciiCharacters")

package ch.keepcalm.tdd.api

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
class IndexApiTest (private val client: WebTestClient) {

    @Test
    fun `Should return a status of 2xx for the API Index Resource`() {
        client.get()
            .uri("/")
            .exchange()
            .expectStatus()
            .is2xxSuccessful
            .expectBody()
    }

    @Test
    fun `Should return a status of 4xx for a non existing API endpoint 🦠`() {
        client.get().uri("/wrong/endpoint").exchange().expectStatus().is4xxClientError
    }
}
