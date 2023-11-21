package br.com.emanuel3k.service

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped
import java.util.stream.Collectors

@ApplicationScoped
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService = CourseService(),
    private val userService: UserService = UserService(),
) {
    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            TopicView(
                id = t.id,
                title = t.title,
                message = t.title,
                creationDate = t.creationDate,
                status = t.status
            )
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicView {
        return topics.stream().map { t ->
            TopicView(
                id = t.id,
                title = t.title,
                message = t.title,
                creationDate = t.creationDate,
                status = t.status
            )
        }.findFirst().get()
    }

    fun register(dto: TopicForm) {
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