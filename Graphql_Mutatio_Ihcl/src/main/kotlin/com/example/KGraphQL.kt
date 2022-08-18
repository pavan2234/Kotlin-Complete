import com.apurebase.kgraphql.GraphQL
import com.example.Schema
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*

fun Application.configureGraphQL() {
    install(ContentNegotiation){
        gson()
    }
    install(GraphQL) {
        playground = true
        schema {
            Schema()
        }
    }
}