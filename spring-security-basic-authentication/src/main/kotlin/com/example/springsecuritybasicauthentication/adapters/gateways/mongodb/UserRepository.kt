package com.example.springsecuritybasicauthentication.adapters.gateways.mongodb

import com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.models.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import uk.co.caeldev.springsecuritymongo.repositories.UserRepository

interface UserRepository : MongoRepository<UserModel, String>, UserRepository {
    fun findByEmail(email: String): UserModel?
}