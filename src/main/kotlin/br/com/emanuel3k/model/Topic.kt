package br.com.emanuel3k.model

import br.com.emanuel3k.model.enums.StatusTopic
import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val answers: List<Answer> = ArrayList(),
    val course: Course,
    val status: StatusTopic = StatusTopic.NOT_ANSWERD,
)