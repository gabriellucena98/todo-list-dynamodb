package com.gb.lucena.todolist.configuration.error

enum class Exception(
    val message: String?,
    val code: String?
) {

    ALREADY_EXISTS_EXCEPTION("Conflict: that object already exists", "409")
}