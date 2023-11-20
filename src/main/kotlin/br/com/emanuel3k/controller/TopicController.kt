package br.com.emanuel3k.controller

import br.com.emanuel3k.model.Topic
import br.com.emanuel3k.service.TopicService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/topics")
class TopicController(
    @Inject
    private val service: TopicService,
) {

    @GET
    fun list(): List<Topic> {
        return service.list()
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long):Topic {
        return service.getById(id)
    }
}