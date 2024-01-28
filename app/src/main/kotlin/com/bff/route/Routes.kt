package com.bff.route

import com.bff.model.Header
import com.bff.model.Screen
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

        get("/bff/calendar") {

            /**
             * Replace instance with data mapped from API call
             */
            val data: Screen = Screen("calendar", Header("Feb 2024"), emptyList())
            call.respond(HttpStatusCode.OK, data)
        }
    }
}
