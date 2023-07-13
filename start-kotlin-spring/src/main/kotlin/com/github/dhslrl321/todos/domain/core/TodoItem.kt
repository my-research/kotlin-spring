package com.github.dhslrl321.todos.domain.core

import com.github.dhslrl321.todos.support.genId
import java.time.LocalDateTime

class TodoItem(
    val id: Long,
    var name: String,
    val status: TodoStatus,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) {
    companion object {
        fun newInstance(name: String): TodoItem {
            return TodoItem(
                id = genId(),
                name = name,
                status = TodoStatus.CREATED,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        }
    }

    fun updateName(name: String) {
        this.name = name
    }
}