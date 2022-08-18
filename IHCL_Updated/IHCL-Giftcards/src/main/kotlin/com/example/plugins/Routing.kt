package com.example.plugins

import com.example.routes.GiftCardConfigureRoute
import io.ktor.server.application.*


fun Application.configureRouting() {
    GiftCardConfigureRoute()
}
