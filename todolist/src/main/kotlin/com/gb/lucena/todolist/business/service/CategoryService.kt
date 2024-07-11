package com.gb.lucena.todolist.business.service

import com.gb.lucena.todolist.business.model.Category

interface CategoryService {
    fun create(category: Category)
}