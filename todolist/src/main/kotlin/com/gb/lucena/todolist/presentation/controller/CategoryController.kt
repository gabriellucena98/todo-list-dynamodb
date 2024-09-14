package com.gb.lucena.todolist.presentation.controller

import com.gb.lucena.todolist.business.service.CategoryService
import com.gb.lucena.todolist.presentation.dto.request.CreateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.request.UpdateCategoryRequestDTO
import com.gb.lucena.todolist.presentation.dto.response.CategoryResponseDTO
import com.gb.lucena.todolist.presentation.mapper.toModel
import com.gb.lucena.todolist.presentation.mapper.toResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/list")
    fun listByEmail(
        @RequestParam email: String
    ): List<CategoryResponseDTO> {
        return categoryService.listByEmail(email).map { it.toResponseDTO() }.sortedBy { it.sequence }
    }

    @DeleteMapping
    fun deleteCategoryById(
        @RequestParam email: String,
        @RequestParam id: String
    ) {
        categoryService.deleteCategoryById(email, id)
    }

    @PutMapping
    fun updateCategory(
        @RequestBody updateCategoryRequestDTO: UpdateCategoryRequestDTO
    ): CategoryResponseDTO {
        val category = updateCategoryRequestDTO.toModel()

        return categoryService.updateCategory(category).toResponseDTO()
    }

    @GetMapping("/{id}")
    fun getCategoryById(
        @RequestParam email: String,
        @PathVariable id: String
    ): CategoryResponseDTO {
        return categoryService.getCategoryById(email, id).toResponseDTO()
    }
}
