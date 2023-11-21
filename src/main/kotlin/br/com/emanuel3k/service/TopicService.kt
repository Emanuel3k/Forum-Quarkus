package br.com.emanuel3k.service

import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
) {
    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun register(topic: Topic) {
        topics.plus(topic)
    }
}