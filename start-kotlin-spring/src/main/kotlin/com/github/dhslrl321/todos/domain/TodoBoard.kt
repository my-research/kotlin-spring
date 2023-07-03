package com.github.dhslrl321.todos.domain

import com.github.dhslrl321.todos.support.genId
import java.time.LocalDateTime

class TodoBoard(
    val id: Long,
    var todos: MutableList<TodoItem>,
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
        val exist = todos.any { it.id == item.id }
        require(exist.not()) { "중복되는 todoItem 은 추가될 수 없습니다" }

        todos += item

        check(todos.isNotEmpty()) { "todo 가 추가되면 todos 에 항상 0보다 커야합니다" }
    }

    fun removeItem(item: TodoItem) {
        require(todos.isNotEmpty()) { "todo 를 삭제하려면 board 가 todo 를 적어도 하나 이상 가져야합니다" }

        val removeIf = todos.removeIf { it.id == item.id }

        check(removeIf) { "board 에 존재하지 않는 item 은 삭제할 수 없습니다" }
    }

    fun countOfItem(): Int = todos.size
}