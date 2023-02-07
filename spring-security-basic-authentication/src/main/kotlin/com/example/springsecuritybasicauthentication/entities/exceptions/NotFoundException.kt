package com.example.springsecuritybasicauthentication.entities.exceptions

class NotFoundException(
    override val message: String?
) : RuntimeException(message)