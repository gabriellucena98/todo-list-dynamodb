package com.gb.lucena.todolist.presentation.controller

import com.gb.lucena.todolist.business.service.CategoryService
import com.gb.lucena.todolist.presentation.dto.request.CreateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.CategoryResponseDTO
import com.gb.lucena.todolist.presentation.mapper.toModel
import com.gb.lucena.todolist.presentation.mapper.toResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody createCategoryRequestDTO: CreateCategoryRequestDTO
    ): CategoryResponseDTO {
        val category = createCategoryRequestDTO.toModel()
        categoryService.create(category)
        return category.toResponseDTO()
    }
}