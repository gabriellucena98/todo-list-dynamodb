package com.gb.lucena.todolist.configuration

import com.gb.lucena.todolist.configuration.error.Error
import com.gb.lucena.todolist.configuration.error.GenericErrorJSONResponse
import com.gb.lucena.todolist.configuration.exception.AlreadyExistsException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalHandlerController {

    private val logger = LoggerFactory.getLogger(GlobalHandlerController::class.java)

    @ExceptionHandler(AlreadyExistsException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    fun handlerAlreadyExistsException(ex: AlreadyExistsException): Error {
        logger.error("That object already exists.", ex)
        return GenericErrorJSONResponse(ex).toJson()
    }
}

