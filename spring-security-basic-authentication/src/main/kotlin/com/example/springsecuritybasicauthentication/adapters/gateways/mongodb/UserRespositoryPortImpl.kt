package com.example.springsecuritybasicauthentication.adapters.gateways.mongodb

import com.example.springsecuritybasicauthentication.entities.User
import com.example.springsecuritybasicauthentication.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserRespositoryPortImpl(
    private val userRepository: UserRepository,
) : UserRepositoryPort {
    override fun getNumberOfUsers(): Result<Long> = kotlin.runCatching {
        userRepository.count()
    }

    override fun findAll(): Result<List<User>> = kotlin.runCatching {
        userRepository.findAll().map { it.toDomain() }
    }

    override fun findUserByEmail(email: String): Result<User?> = kotlin.runCatching {
        userRepository.findByEmail(email)?.toDomain()
    }
}