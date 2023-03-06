package com.example.springsecuritybasicauthentication.adapters.controllers.exceptions

import com.example.springsecuritybasicauthentication.adapters.controllers.dtos.ErrorResponseDto
import com.example.springsecuritybasicauthentication.entities.exceptions.NotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: RuntimeException, request: HttpServletRequest): ErrorResponseDto {
        return ErrorResponseDto(error = exception.message)
    }
}