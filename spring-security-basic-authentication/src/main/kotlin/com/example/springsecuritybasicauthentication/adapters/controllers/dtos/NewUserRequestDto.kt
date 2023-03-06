package com.example.springsecuritybasicauthentication.adapters.controllers.dtos

data class NewUserRequestDto(
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val enabled: Boolean? = true,
)
