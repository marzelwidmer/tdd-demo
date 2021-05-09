package ch.keepcalm.tdd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TDDApplication

fun main(args: Array<String>) {
	runApplication<TDDApplication>(*args)
}
