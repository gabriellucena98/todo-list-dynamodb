package com.gb.lucena.todolist.business.service

import com.gb.lucena.todolist.business.model.Category

interface CategoryService {
    fun create(category: Category)
    fun listByEmail(email: String): List<Category>
    fun deleteCategoryById(email: String, id: String)
    fun updateCategory(category: Category): Category
    fun getCategoryById(email: String, id: String): Category
}
