package com.example.springsecuritybasicauthentication.controllers.dtos

import com.example.springsecuritybasicauthentication.entities.User

class UserResponseDto(
    val username: String,
    val email: String,
    val enabled: Boolean,
) {
    companion object {
        fun fromDomain(user: User): UserResponseDto {
            return UserResponseDto(
                username = user.username,
                email = user.email,
                enabled = user.enabled,
            )
        }
    }
}