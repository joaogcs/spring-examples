package com.example.springsecuritybasicauthentication.gateways.repositories.h2

import com.example.springsecuritybasicauthentication.entities.exceptions.NotFoundException
import com.example.springsecuritybasicauthentication.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryPortImpl(val userRepository: UserRepository) : UserRepositoryPort {
    override fun getNumberOfUsers() = userRepository.findAll().count()
    override fun findAll() = userRepository.findAll().map { it.toDomain() }
    override fun findUserByEmail(email: String) =
        userRepository.findByEmail(email)?.toDomain() ?: throw NotFoundException("user not found")
}