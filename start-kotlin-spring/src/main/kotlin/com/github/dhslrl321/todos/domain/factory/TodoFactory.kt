package com.github.dhslrl321.todos.domain.factory

import com.github.dhslrl321.todos.domain.core.TodoItem

interface TodoFactory {
    fun create(command: CreateTodoCommand): TodoItem
}
