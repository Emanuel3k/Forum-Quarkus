/*
package br.com.emanuel3k.service

import br.com.emanuel3k.model.Answer
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class AnswerService(
    private var answers: List<Answer> = ArrayList(),
    private val topicService: TopicService = TopicService(),
    private val answerFormMapper: AnswerFormMapper = AnswerFormMapper()
) {
    fun list(id: Long): List<Answer> {
        return answers
    }

    fun getById(id: Long): Answer {
        val answer = answers.stream().filter { a ->
            a.id == id
        }.findFirst().get()

        return answerViewMapper.map(answer)
    }

    fun register(id: Long, dto: AnswerForm  ) {
        val answer = answerFormMapper.map(dto)
        answer.id = answers.size.toLong() + 1
        answer.topic = topicService.getById(id)
        answers = answers.plus(answer)
    }


}
*/
