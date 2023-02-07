package com.example.springsecuritybasicauthentication.usecases.ports

import com.example.springsecuritybasicauthentication.entities.User

interface UserRepositoryPort {
    fun getNumberOfUsers(): Int
    fun findAll(): List<User>
    fun findUserByEmail(email: String): User
}