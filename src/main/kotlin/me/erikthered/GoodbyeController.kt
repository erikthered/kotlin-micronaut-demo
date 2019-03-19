package me.erikthered

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/goodbye")
class GoodbyeController {
    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {
        return "Bye bye"
    }
}