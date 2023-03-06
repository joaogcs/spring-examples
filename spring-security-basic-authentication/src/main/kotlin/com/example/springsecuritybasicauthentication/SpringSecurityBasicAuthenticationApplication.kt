package com.example.springsecuritybasicauthentication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class SpringKotlinUserAuthPostgresqlApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinUserAuthPostgresqlApplication>(*args)
}
