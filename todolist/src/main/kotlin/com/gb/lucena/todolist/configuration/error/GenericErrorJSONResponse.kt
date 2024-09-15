package com.gb.lucena.todolist.configuration.error

import kotlin.reflect.full.memberProperties

open class GenericErrorJSONResponse<T: Any>(private val ex: T) {
    fun toJson(): Error {
        // Usando reflexão para acessar as propriedades "message", "name", e "code"
        val message = ex::class.memberProperties
            .firstOrNull { it.name == "message" }
            ?.getter
            ?.call(ex) as? String ?: "Message not found"

        return Error(message)
    }
}