package br.com.emanuel3k.mapper

import br.com.emanuel3k.dto.TopicForm
import br.com.emanuel3k.model.Topic
import br.com.emanuel3k.service.CourseService
import br.com.emanuel3k.service.UserService
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TopicFormMapper(
    private val courseService: CourseService = CourseService(),
    private val userService: UserService = UserService(),

    ) : Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse),
            author = userService.getById(t.idAuthor)
        )
    }
}
