package br.com.emanuel3k.controller

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.service.TopicService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/topics")
class TopicController(
    @Inject
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
    fun register(dto: TopicForm) {
        service.register(dto)
    }
}