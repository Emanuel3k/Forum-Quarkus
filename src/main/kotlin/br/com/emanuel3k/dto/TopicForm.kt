package br.com.emanuel3k.dto

data class TopicForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long,
)
