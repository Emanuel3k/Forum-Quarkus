package br.com.emanuel3k.service

import br.com.emanuel3k.model.Course
import br.com.emanuel3k.model.Topic
import br.com.emanuel3k.model.User
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
) {

    init {
        val t1 = Topic(
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
        val t2 = Topic(
            id = 2,
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
        val t3 = Topic(
            id = 3,
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

        this.topics = arrayListOf(t1, t2, t3)
    }

    fun list(): List<Topic> {
        return topics
    }
}