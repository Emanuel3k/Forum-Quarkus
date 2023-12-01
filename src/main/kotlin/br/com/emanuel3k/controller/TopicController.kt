package br.com.emanuel3k.controller

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicUpdate
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.service.TopicService
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.*

@Path("/topics")
class TopicController(
    @field:Inject
    private val service: TopicService,
) {

    @GET
    fun list(): List<TopicView> {
        return service.list()
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): TopicView {
        return service.getById(id)
    }

    @POST
    fun register(@Valid dto: TopicForm) {
        service.register(dto)
    }

    @PUT
    fun update(@Valid dto: TopicUpdate) {
        service.update(dto)
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long) {
        service.delete(id)
    }
}