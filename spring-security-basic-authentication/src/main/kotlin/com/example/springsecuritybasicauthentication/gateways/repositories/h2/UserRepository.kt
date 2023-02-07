package com.example.springsecuritybasicauthentication.gateways.repositories.h2

import com.example.springsecuritybasicauthentication.gateways.repositories.h2.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserModel, String> {
    fun findByEmail(email: String): UserModel?
}