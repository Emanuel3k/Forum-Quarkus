package br.com.emanuel3k.service

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicUpdate
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.mapper.TopicFormMapper
import br.com.emanuel3k.mapper.TopicViewMapper
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.util.stream.Collectors

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
) {
    @Inject
    private lateinit var topicViewMapper: TopicViewMapper
    @Inject
    private lateinit var topicFormMapper: TopicFormMapper

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun register(dto: TopicForm) {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun update(dto: TopicUpdate) {
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
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        topics = topics.minus(topic)
    }
}