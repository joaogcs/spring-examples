package com.example.springsecuritybasicauthentication.usecases

import com.example.springsecuritybasicauthentication.usecases.ports.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class GetUserUseCase(val userRepositoryPort: UserRepositoryPort) {
    fun all() = userRepositoryPort.findAll().getOrThrow()
    fun countAll() = userRepositoryPort.getNumberOfUsers().getOrThrow()
    fun byEmail(email: String) = userRepositoryPort.findUserByEmail(email).getOrThrow()
}