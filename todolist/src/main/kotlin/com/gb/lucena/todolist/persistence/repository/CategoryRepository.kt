package com.gb.lucena.todolist.persistence.repository

import com.gb.lucena.todolist.persistence.data.CategoryData

interface CategoryRepository {
    fun create(categoryData: CategoryData)
}