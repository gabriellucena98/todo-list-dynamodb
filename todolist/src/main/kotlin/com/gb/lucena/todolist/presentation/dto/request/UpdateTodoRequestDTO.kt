package com.gb.lucena.todolist.presentation.dto.request

import java.util.UUID

data class UpdateTodoRequestDTO(
    val id: UUID,
    val name: String,
    val description: String?,
    val done: Boolean,
    val sequence: Int? = null
)
