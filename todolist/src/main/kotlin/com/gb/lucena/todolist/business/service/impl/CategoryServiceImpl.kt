package com.gb.lucena.todolist.business.service.impl

import com.gb.lucena.todolist.business.model.Category
import com.gb.lucena.todolist.business.service.CategoryService
import com.gb.lucena.todolist.business.mapper.toData
import com.gb.lucena.todolist.persistence.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
): CategoryService {

    override fun create(category: Category) {
        categoryRepository.create(category.toData())
    }

}