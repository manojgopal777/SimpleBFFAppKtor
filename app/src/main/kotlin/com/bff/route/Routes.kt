package com.bff.route

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.routes() {
    @kotlinx.serialization.Serializable
    data class Info(val version: String)

    routing {
        get("/bff/health") {
            val info = Info(this@routing.application.environment.config.config("info").property("version").getString())
            call.respond(HttpStatusCode.OK, info)
        }
    }
}
