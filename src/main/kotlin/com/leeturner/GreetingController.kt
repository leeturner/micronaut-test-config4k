package com.leeturner

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/greeting")
class GreetingController(private val greetingConfig: GreetingConfig) {

  @Get("/hello")
  fun hello(): String {
    return greetingConfig.message
  }
}
