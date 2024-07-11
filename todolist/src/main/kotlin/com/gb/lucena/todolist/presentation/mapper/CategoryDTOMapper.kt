package com.gb.lucena.todolist.presentation.mapper

import com.gb.lucena.todolist.business.model.Category
import com.gb.lucena.todolist.presentation.dto.request.CreateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.CategoryResponseDTO
import java.time.Instant
import java.util.*

fun CreateCategoryRequestDTO.toModel(): Category {
    return Category(email, UUID.randomUUID(), name, description, todos?.map { it.toModel() }, Instant.now(), Instant.now())
}

fun Category.toResponseDTO(): CategoryResponseDTO {
    return CategoryResponseDTO(id, name, description, todos?.map { it.toResponseDTO() }, createdAt, updatedAt)
}