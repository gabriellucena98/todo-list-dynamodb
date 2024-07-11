package com.gb.lucena.todolist.presentation.dto.response

import java.time.Instant
import java.util.UUID

data class CategoryResponseDTO(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val todos: List<TodoResponseDTO>?,
    val createdAt: Instant,
    val updatedAt: Instant
)
