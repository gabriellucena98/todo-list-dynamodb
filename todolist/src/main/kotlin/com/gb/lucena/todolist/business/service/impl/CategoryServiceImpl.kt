package com.gb.lucena.todolist.business.service.impl

import com.gb.lucena.todolist.business.mapper.toData
import com.gb.lucena.todolist.business.mapper.toModel
import com.gb.lucena.todolist.business.model.Category
import com.gb.lucena.todolist.business.service.CategoryService
import com.gb.lucena.todolist.configuration.error.Exception
import com.gb.lucena.todolist.configuration.exception.AlreadyExistsException
import com.gb.lucena.todolist.persistence.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {

    override fun create(category: Category) {
        categoryRepository.existsByEmailAndName(category.email, category.name)
            .takeIf { it }
            ?.run { throw AlreadyExistsException(Exception.ALREADY_EXISTS_EXCEPTION, category.name) }
        categoryRepository.create(category.toData())
    }

    override fun listByEmail(email: String): List<Category> {
        return runCatching {
            categoryRepository.listByEmail(email).map { it.toModel() }
        }.getOrElse {
            throw it
        }
    }

    override fun deleteCategoryById(email: String, id: String) {
        categoryRepository.deleteCategoryById(email, id)
    }

    override fun updateCategory(category: Category): Category {
        return categoryRepository.updateCategory(category.toData()).toModel()
    }

    override fun getCategoryById(email: String, id: String): Category {
        return categoryRepository.getCategoryById(email, id).toModel()
    }
}
