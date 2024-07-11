package com.gb.lucena.todolist.presentation.mapper

import com.gb.lucena.todolist.business.model.Todo
import com.gb.lucena.todolist.presentation.dto.request.CreateTodoRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.TodoResponseDTO
import java.time.Instant
import java.util.*

fun CreateTodoRequestDTO.toModel(): Todo {
    return Todo(UUID.randomUUID(), name, description, false, Instant.now(), Instant.now())
}

fun Todo.toResponseDTO(): TodoResponseDTO {
    return TodoResponseDTO(id, name, description, done, createdAt, updatedAt)
}