package com.example.springsecuritybasicauthentication.controllers.exceptions

import com.example.springsecuritybasicauthentication.entities.exceptions.NotFoundException
import com.example.springsecuritybasicauthentication.controllers.dtos.ErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(exception: RuntimeException, request: HttpServletRequest): ErrorResponseDto {
        return ErrorResponseDto(error = exception.message)
    }
}