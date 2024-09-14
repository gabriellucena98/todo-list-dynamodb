package com.gb.lucena.todolist.presentation.dto.response

import java.util.UUID

data class TodoResponseDTO(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val done: Boolean? = false,
    val sequence: Int? = null
)
