package com.github.dhslrl321.todos.application

import com.github.dhslrl321.todos.domain.core.TodoItem
import com.github.dhslrl321.todos.domain.factory.CreateTodoCommand
import com.github.dhslrl321.todos.domain.factory.TodoFactory

class SimpleTodoFactory : TodoFactory {
    override fun create(command: CreateTodoCommand): TodoItem {
        return TodoItem.newInstance(command.name)
    }
}
