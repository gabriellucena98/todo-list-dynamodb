package com.gb.lucena.todolist.presentation.dto.request

data class CreateCategoryRequestDTO(
    val email: String,
    val name: String,
    val description: String?,
    val todos: List<CreateTodoRequestDTO>? = null
)
