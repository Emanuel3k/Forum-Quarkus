package br.com.emanuel3k.controller

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicUpdate
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.service.TopicService
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response

@Path("/topics")
class TopicController {
    @Inject
    private lateinit var service: TopicService

    @GET
    fun list(): Response {
        return service.list()
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): Response {
        return service.getById(id)
    }

    @POST
    fun register(@Valid dto: TopicForm): Response {
        return service.register(dto)
    }

    @PUT
    fun update(@Valid dto: TopicUpdate): Response {
        return service.update(dto)
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long): Response {
        return service.delete(id)
    }
}