package com.gb.lucena.todolist.business.mapper

import com.gb.lucena.todolist.business.model.Todo
import com.gb.lucena.todolist.persistence.data.TodoData

fun Todo.toData(): TodoData {
    return TodoData(id, name, description, done, sequence)
}

fun TodoData.toModel(): Todo {
    return Todo(id!!, name!!, description, done!!, sequence)
}
