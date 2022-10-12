package at.stefangaller.routes

import at.stefangaller.data.Shop
import at.stefangaller.services.ShopService
import io.ktor.application.call
import io.ktor.features.NotFoundException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Route.shops() {
    val shopService by di().instance<ShopService>()
    get("/shops") {
        val allShops = shopService.getAllShops()
        call.respond(allShops)
    }
    post("/shop") {
        val shopRequest = call.receive<Shop>()
        shopService.addShop(shopRequest)
        call.respond(shopRequest)
    }
    delete("/deleteById") {
        val shopid = call.parameters["shopid"]?.toIntOrNull()?: throw NotFoundException()
        shopService.deleteShop(shopid)
        call.respond(HttpStatusCode.OK)
    }
}