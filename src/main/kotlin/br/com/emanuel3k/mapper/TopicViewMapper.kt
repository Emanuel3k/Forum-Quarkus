package br.com.emanuel3k.mapper

import br.com.emanuel3k.dto.TopicView
import br.com.emanuel3k.model.Topic
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.title,
            creationDate = t.creationDate,
            status = t.status
        )
    }
}