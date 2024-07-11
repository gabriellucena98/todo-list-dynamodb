package com.gb.lucena.todolist.business.model

import java.time.Instant
import java.util.UUID

data class Todo(
    val id: UUID,
    val name: String,
    val description: String?,
    val done: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant
)
