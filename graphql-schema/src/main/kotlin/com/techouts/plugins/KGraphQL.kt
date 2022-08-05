import com.apurebase.kgraphql.GraphQL
import com.techouts.schema.NomineeSchema
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun Application.configureGraphQL() {
    install(ContentNegotiation){
        json()
    }
    install(GraphQL) {
        playground = true
        schema {
           // reservationSchema()
           // giftCardsSchema()
            NomineeSchema()
        }
    }
}