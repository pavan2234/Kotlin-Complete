package ihcl.com

import ihcl.com.dbconfig.DatabaseFactory
import ihcl.com.plugins.configureRouting
import ihcl.com.plugins.configureSecurity
import ihcl.com.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*

fun main() {
    embeddedServer(Tomcat, port = 8081, host = "localhost") {

        DatabaseFactory.init()
        configureRouting()
        configureSerialization()
        //configureSecurity()

    }.start(wait = true)
}
