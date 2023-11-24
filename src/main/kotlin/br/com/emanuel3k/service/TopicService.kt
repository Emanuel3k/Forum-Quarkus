package br.com.emanuel3k.service

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicUpdate
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.mapper.TopicFormMapper
import br.com.emanuel3k.mapper.TopicViewMapper
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped
import java.util.stream.Collectors

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper = TopicViewMapper(),
    private val topicFormMapper: TopicFormMapper = TopicFormMapper(),
) {
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
        val topic = topics.stream().filter{t ->
            t.id == dto.id
        }.findFirst().get()

        topics = topics.minus(topic).plus(Topic(
            id = dto.id,
            message = dto.message,
            title = dto.title,
            author = topic.author,
            creationDate = topic.creationDate,
            status = topic.status,
            course = topic.course,
        ))
    }
}