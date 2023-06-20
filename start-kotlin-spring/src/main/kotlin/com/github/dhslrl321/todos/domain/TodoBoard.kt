package com.github.dhslrl321.todos.domain

import com.github.dhslrl321.todos.support.genId
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

class TodoBoard(
    val id: Long,
    var todos: List<TodoItem>,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) {
    companion object {
        fun newInstance(): TodoBoard {
            return TodoBoard(
                id = genId(),
                todos = ArrayList(),
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        }
    }

    fun addItem(item: TodoItem) {
        val isExist = todos.any { it.id == item.id }
        require(isExist) {"중복되는 todoItem 은 추가될 수 없습니다"}

        todos += item

        check(todos.isNotEmpty()) { "todo 가 추가되면 todos 에 항상 0보다 커야합니다" }
    }

    fun countOfItem(): Int = todos.size
}