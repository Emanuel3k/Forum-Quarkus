package br.com.emanuel3k.dto

data class NewTopicDTO(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long,
)
