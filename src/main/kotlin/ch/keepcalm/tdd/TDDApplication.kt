package ch.keepcalm.tdd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.hateoas.support.WebStack
import org.springframework.web.server.adapter.ForwardedHeaderTransformer

@SpringBootApplication
@EnableHypermediaSupport(stacks = [WebStack.WEBFLUX], type = [EnableHypermediaSupport.HypermediaType.HAL])
class TDDApplication {
	@Bean
	fun forwardedHeaderTransformer(): ForwardedHeaderTransformer = ForwardedHeaderTransformer()
}

fun main(args: Array<String>) {
	runApplication<TDDApplication>(*args)
}

