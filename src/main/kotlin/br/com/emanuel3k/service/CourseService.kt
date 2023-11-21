package br.com.emanuel3k.service

import br.com.emanuel3k.model.Course
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CourseService(
    private var courses: List<Course> = ArrayList(),
) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        courses = arrayListOf(course)
    }

    fun getById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}
