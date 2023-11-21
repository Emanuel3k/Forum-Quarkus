package br.com.emanuel3k.dto

import br.com.emanuel3k.model.enums.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val creationDate: LocalDateTime,
)


