package com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.models

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "authorities")
class AuthoritiesModel(
    val username: String,
    val authority: String,
    @DBRef()
    val user: UserModel,
)