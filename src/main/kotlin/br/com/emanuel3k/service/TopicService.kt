package br.com.emanuel3k.service

import br.com.emanuel3k.dto.NewTopicDTO
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService = CourseService(),
    private val userService: UserService = UserService(),
) {
    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun register(dto: NewTopicDTO) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = dto.title,
                message = dto.message,
                course = courseService.getById(dto.idCourse),
                author = userService.getById(dto.idAuthor)
            )
        )
    }
}