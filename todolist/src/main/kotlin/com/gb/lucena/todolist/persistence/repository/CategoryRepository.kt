package com.gb.lucena.todolist.persistence.repository

import com.gb.lucena.todolist.persistence.data.CategoryData

interface CategoryRepository {
    fun create(categoryData: CategoryData)
    fun existsByEmailAndName(email: String, name: String): Boolean
    fun listByEmail(email: String): List<CategoryData>
    fun deleteCategoryById(email: String, id: String)
    fun updateCategory(data: CategoryData): CategoryData
    fun getCategoryById(email: String, id: String): CategoryData
}
