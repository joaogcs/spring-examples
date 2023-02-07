package com.example.springsecuritybasicauthentication.entities

data class User(
    val username: String,
    val email: String,
    val password: String? = null,
    val enabled: Boolean,
)