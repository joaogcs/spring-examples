package com.example.springsecuritybasicauthentication.adapters.controllers

import com.example.springsecuritybasicauthentication.adapters.controllers.dtos.NewUserRequestDto
import com.example.springsecuritybasicauthentication.adapters.controllers.dtos.UserResponseDto
import com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.UserRepository
import com.example.springsecuritybasicauthentication.adapters.gateways.mongodb.models.UserModel
import com.example.springsecuritybasicauthentication.entities.exceptions.NotFoundException
import com.example.springsecuritybasicauthentication.usecases.GetUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(
    private val getUserUseCase: GetUserUseCase,
    private val userRepository: UserRepository,
) {

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    fun findAllUsers() = getUserUseCase.all().map { user -> UserResponseDto.fromDomain(user) }

    @GetMapping("count")
    @ResponseStatus(HttpStatus.OK)
    fun getNumberOfUsers() = getUserUseCase.countAll().toString()

    @GetMapping("email/{email}")
    @ResponseStatus(HttpStatus.OK)
    fun findUserByEmail(@PathVariable("email") email: String): UserResponseDto {
        val user = getUserUseCase.byEmail(email) ?: throw NotFoundException("User not found")
        return UserResponseDto.fromDomain(user)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody newUserRequestDto: NewUserRequestDto) = userRepository.save(
        UserModel(
            username = "test",
            email = "test",
            password = "test",
            enabled = true,
        )
    )
}
