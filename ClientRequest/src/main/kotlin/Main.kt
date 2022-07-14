import kotlinx.coroutines.runBlocking
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.date.*

fun main(args: Array<String>) {
    runBlocking {
        val client = HttpClient(CIO)
//        val response: HttpResponse = client.get("https://ktor.io/")
//        println(response.request.url)
       // println(response.bodyAsText())


//        val response: HttpResponse = client.request("https://ktor.io/") /*But in above we have written directly*/
//        method =HttpMethod.Get
//        println(response.bodyAsText())

//        val response: HttpResponse = client.get("https://ktor.io/docs/welcome.html")
//        println(response.bodyAsText())

//          val response:HttpResponse = client.get {
//              url {
//                  protocol = URLProtocol.HTTPS
//                  host="ktor.io"
//                  path("docs/welcome.html")
//              }
//          }
//        println(response.bodyAsText())

//        val response2:HttpResponse =client.get{
//            url{
//                protocol = URLProtocol.HTTPS
//                host="ktor.io"
//                appendPathSegments("docs","welcome.html")
//                parameters.append("pabv","45")
//                encodedParameters.append("babu","21")
//                fragment="pavan123"
//                encodedFragment="encoded123"
//            }
//        }
//        println(response2)
//        val response3:HttpResponse=client.get("https://ktor.io"){
//            headers {
//                append(HttpHeaders.Accept,"text/html")
//                append(HttpHeaders.Authorization,"abc123")//authorise restricted documents
//                append(HttpHeaders.UserAgent,"ktor client")
//            }
//        }
//        println(response3)

//        val response4: HttpResponse = client.post("http://localhost:8080/post"){
//            setBody("Details")
//        }
//       println(response4)

//        val response5:HttpResponse=client.get("http://localhost:8080/post")
//        println(response5.bodyAsText())

        val response6:HttpResponse=client.get("http://localhost:8080/post"){
            url{
                parameters.append("babu","1860")
            }
        }
        println(response6)
 }
}