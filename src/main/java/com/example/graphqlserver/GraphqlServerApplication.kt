package com.example.graphqlserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlServerApplication

fun main(args: Array<String>) {
    runApplication<GraphqlServerApplication>(*args)
}
