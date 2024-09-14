package com.gb.lucena.todolist.presentation.mapper

import com.gb.lucena.todolist.business.model.Todo
import com.gb.lucena.todolist.presentation.dto.request.CreateTodoRequestDTO
import com.gb.lucena.todolist.presentation.dto.request.UpdateTodoRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.TodoResponseDTO
import java.util.UUID

fun CreateTodoRequestDTO.toModel(index: Int): Todo {
    return Todo(UUID.randomUUID(), name, description, false, sequence = index)
}

fun Todo.toResponseDTO(): TodoResponseDTO {
    return TodoResponseDTO(id, name, description, done, sequence)
}

fun UpdateTodoRequestDTO.toModel(index: Int): Todo {
    return Todo(id, name, description, done, sequence = index)
}
