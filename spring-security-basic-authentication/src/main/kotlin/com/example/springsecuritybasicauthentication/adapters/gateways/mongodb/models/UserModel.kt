package com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.models

import com.example.springsecuritybasicauthentication.entities.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class UserModel(
    @Id val username: String,
    val email: String,
    private val password: String,
    val enabled: Boolean,
) {
    fun toDomain(): User {
        return User(
            username = username,
            email = email,
            password = password,
            enabled = enabled,
        )
    }
}