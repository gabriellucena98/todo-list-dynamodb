package com.gb.lucena.todolist.configuration.exception

import com.gb.lucena.todolist.configuration.error.Exception

open class AlreadyExistsException(ex: Exception, name: String) : RuntimeException("${ex.message}: $name")