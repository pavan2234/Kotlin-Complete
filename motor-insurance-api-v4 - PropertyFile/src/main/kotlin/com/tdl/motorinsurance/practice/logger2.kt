package com.tdl.motorinsurance.practice

import mu.KotlinLogging
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val logger2 = LoggerFactory.getLogger("package.ClassName")
private val logger3 = KotlinLogging.logger("The Name")

fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)


fun getLogger(): Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)

fun getLogger(name: String): Logger = LoggerFactory.getLogger(name)