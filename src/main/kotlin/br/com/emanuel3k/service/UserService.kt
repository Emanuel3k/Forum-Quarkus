package br.com.emanuel3k.service

import br.com.emanuel3k.model.User
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserService(
    private var users: List<User> = ArrayList(),
) {
    init {
        val user = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com.br"
        )
        users = arrayListOf(user)
    }

    fun getById(id: Long): User {
        return users.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }
}
