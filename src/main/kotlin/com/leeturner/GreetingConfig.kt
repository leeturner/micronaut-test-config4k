package com.leeturner

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("greeting")
data class GreetingConfig (
    val message: String = "Hi there!"
)