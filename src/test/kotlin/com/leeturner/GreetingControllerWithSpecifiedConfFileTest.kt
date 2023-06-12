package com.leeturner

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest(propertySources = ["classpath:my-greeting.conf"])
class GreetingControllerWithSpecifiedConfFileTest(private val greetingConfig: GreetingConfig) {

  @Inject @Client("/") lateinit var client: HttpClient

  @Test
  internal fun `the greeting controller returns the configured message`() {
    val response = client.toBlocking().retrieve("/greeting/hello")
    println("Greeting should be '${greetingConfig.message}'")
    assertEquals(greetingConfig.message, response)
  }
}
