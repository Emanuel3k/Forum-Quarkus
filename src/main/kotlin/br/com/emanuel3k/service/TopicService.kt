package br.com.emanuel3k.service

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicUpdate
import br.com.emanuel3k.mapper.TopicFormMapper
import br.com.emanuel3k.mapper.TopicViewMapper
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.core.Response
import java.net.URI
import java.util.stream.Collectors

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
) {
    @Inject
    private lateinit var topicViewMapper: TopicViewMapper

    @Inject
    private lateinit var topicFormMapper: TopicFormMapper

    fun list(): Response {
        if (topics.isEmpty()) {
            return Response.noContent().build()
        }

        return try {

            Response.ok(topics.stream().map { t ->
                topicViewMapper.map(t)
            }.collect(Collectors.toList())).build()

        } catch (e: Exception) {
            Response.status(400, "ERROR: ${e.message}").build()
        }
    }

    fun getById(id: Long): Response {
        return try {
            val topic = topics.stream().filter { t ->
                t.id == id
            }.findFirst().get()

            Response.ok(topicViewMapper.map(topic)).build()
        } catch (e: Exception) {
            Response.status(400, "ERROR: ${e.message}").build()
        }
    }

    fun register(dto: TopicForm): Response {
        return try {
            val topic = topicFormMapper.map(dto)
            topic.id = topics.size.toLong() + 1
            topics = topics.plus(topic)
            Response.created(URI("/topic/${topic.id}")).build()

        } catch (e: Exception) {
            Response.status(400, "ERROR: ${e.message}").build()
        }
    }

    fun update(dto: TopicUpdate): Response {
        return try {
            val topic = topics.stream().filter { t ->
                t.id == dto.id
            }.findFirst().get()

            topics = topics.minus(topic).plus(
                Topic(
                    id = dto.id,
                    message = dto.message,
                    title = dto.title,
                    author = topic.author,
                    creationDate = topic.creationDate,
                    status = topic.status,
                    course = topic.course,
                )
            )

            return Response.ok(topicViewMapper.map(topic)).build()
        } catch (e: Exception) {
            Response.status(400, "ERROR: ${e.message}").build()
        }
    }

    fun delete(id: Long): Response {
        return try {
            val topic = topics.stream().filter { t ->
                t.id == id
            }.findFirst().get()

            topics = topics.minus(topic)
            Response.ok("Deletado com sucesso!").build()
        } catch (e: Exception) {
            Response.status(400, "${e.message}").build()
        }

    }
}