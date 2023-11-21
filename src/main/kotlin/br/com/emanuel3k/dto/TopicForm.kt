package br.com.emanuel3k.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 50) val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val idCourse: Long,
    @field:NotNull val idAuthor: Long,
)
