package com.gb.lucena.todolist.business.model

import java.util.UUID

data class Todo(
    val id: UUID,
    val name: String,
    val description: String?,
    val done: Boolean,
    val sequence: Int? = null
)
