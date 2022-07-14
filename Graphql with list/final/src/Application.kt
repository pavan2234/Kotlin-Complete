
package com.raywenderlich.kgraphqlfootball

import com.apurebase.kgraphql.GraphQL
import io.ktor.application.Application
import io.ktor.application.install

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.module(testing: Boolean = false) {
    install(GraphQL) {
        playground = true
        schema { schemaValue() }
    }
}

