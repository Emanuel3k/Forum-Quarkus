/*
package br.com.emanuel3k.controller

import br.com.emanuel3k.model.Answer
import br.com.emanuel3k.service.AnswerService
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/topics/{id}/answers")
class AnswerController(
    @Inject
    private val service: AnswerService,
) {

    @GET
    fun list(id: Long): List<Answer> {
        return service.list(id)
    }

    @GET
    @Path("/{id}")
    fun getGetId(@PathParam("id") id: Long): Answer {
        return service.getById(id)
    }

    @POST
    @Path("/{id}")
    fun register(@PathParam("id") id: Long, @Valid dto: AnswerForm) {
        service.register(id, dto)
    }
}*/
