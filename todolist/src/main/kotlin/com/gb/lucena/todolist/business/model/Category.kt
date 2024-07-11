package com.gb.lucena.todolist.business.model

import java.time.Instant
import java.util.UUID

data class Category(
    val email: String,
    val id: UUID,
    val name: String,
    val description: String?,
    val todos: List<Todo>? = null,
    val createdAt: Instant,
    val updatedAt: Instant
)
