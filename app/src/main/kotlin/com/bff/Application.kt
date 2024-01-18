package com.bff

import com.bff.route.routes
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cachingheaders.CachingHeaders
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json


fun Application.main() {
    cacheHeaders()
    logging()
    contentNegotiation()
    setupRoutes()
}

private fun Application.setupRoutes() {
    routes()
}

private fun Application.contentNegotiation() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }
}

private val json = Json {
    encodeDefaults = true
}

private fun Application.logging() {
    install(CallLogging) {
    }
}

private fun Application.cacheHeaders() {
    install(CachingHeaders) {}
}