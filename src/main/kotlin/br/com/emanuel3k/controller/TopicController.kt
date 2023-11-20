package br.com.emanuel3k.controller

import br.com.emanuel3k.model.Course
import br.com.emanuel3k.model.Topic
import br.com.emanuel3k.model.User
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path

@Path("/topics")
class TopicController {

    @GET
    fun list(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        return  arrayListOf(topic, topic)
    }
}