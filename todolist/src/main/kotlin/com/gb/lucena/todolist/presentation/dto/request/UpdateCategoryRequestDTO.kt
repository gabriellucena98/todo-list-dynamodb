package com.gb.lucena.todolist.presentation.dto.request

import java.util.UUID

data class UpdateCategoryRequestDTO(
    val email: String,
    val id: UUID,
    val name: String,
    val description: String?,
    val todos: List<UpdateTodoRequestDTO>? = null,
    val sequence: Int? = null
)
