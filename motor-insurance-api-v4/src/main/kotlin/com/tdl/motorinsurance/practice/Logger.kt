package com.tdl.motorinsurance.practice

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

val bigEvaluationFunction: (String) -> String = {
    println("I am a VERY BIG evaluation: $it")
    "Big Evaluation"
}

fun main() {
    logger.trace { "This is trace log" }
    logger.debug { "This is debug log" }
    logger.info { "This is info log" }
    logger.warn { "This is warn log" }
    logger.error { "This is error log" }
    logger.trace("Running big evaluation: ${bigEvaluationFunction("eagerly")}")
}