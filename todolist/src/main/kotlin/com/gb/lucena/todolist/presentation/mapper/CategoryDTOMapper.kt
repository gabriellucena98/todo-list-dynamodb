package com.gb.lucena.todolist.presentation.mapper

import com.gb.lucena.todolist.business.model.Category
import com.gb.lucena.todolist.presentation.dto.request.CreateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.request.UpdateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.CategoryResponseDTO
import java.time.Instant
import java.util.UUID

fun CreateCategoryRequestDTO.toModel(): Category {
    return Category(
        email,
        UUID.randomUUID(),
        name,
        description,
        todos?.mapIndexed { index, todo -> todo.toModel(index) },
        Instant.now(),
        Instant.now(),
        sequence
    )
}

fun Category.toResponseDTO(): CategoryResponseDTO {
    return CategoryResponseDTO(
        id,
        name,
        description,
        todos?.map { it.toResponseDTO() }?.sortedBy { it.sequence },
        createdAt,
        updatedAt,
        sequence
    )
}

fun UpdateCategoryRequestDTO.toModel(): Category {
    return Category(
        email,
        id,
        name,
        description,
        todos?.mapIndexed { index, todo -> todo.toModel(index) },
        Instant.now(),
        Instant.now(),
        sequence
    )
}
