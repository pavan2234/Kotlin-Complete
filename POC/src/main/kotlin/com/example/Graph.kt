import com.apurebase.kgraphql.GraphQL
import io.ktor.application.Application
import io.ktor.application.install

fun Application.configureGraphQL() {
    install(GraphQL) {
        playground = true
        schema {
            // TODO: next section
        }
    }
}