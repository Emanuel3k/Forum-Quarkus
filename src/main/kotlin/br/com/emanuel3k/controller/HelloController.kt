package br.com.emanuel3k.controller

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/hello")
class HelloController {

    @GET
    fun hello(): String {
        return "Hello World"
    }
}