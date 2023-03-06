package com.example.springsecuritybasicauthentication.usecases.ports

import com.example.springsecuritybasicauthentication.entities.User

interface UserRepositoryPort {
    fun getNumberOfUsers(): Result<Long>
    fun findAll(): Result<List<User>>
    fun findUserByEmail(email: String): Result<User?>
}