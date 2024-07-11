package com.gb.lucena.todolist.business.mapper

import com.gb.lucena.todolist.business.model.Category
import com.gb.lucena.todolist.persistence.data.CategoryData

fun Category.toData(): CategoryData {
    return CategoryData(email, id, name, description, todos?.map { it.toData() }, createdAt, updatedAt)
}