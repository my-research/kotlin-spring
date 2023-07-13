package com.github.dhslrl321.todos.domain

import com.github.dhslrl321.todos.domain.core.TodoBoard
import com.github.dhslrl321.todos.domain.core.TodoItem
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class Remove_Item_TodoBoardTest: ShouldSpec({
    context("todoBoard 에 A item 이 존재하는데") {
        val sut = TodoBoard.newInstance()
        val itemA = TodoItem.newInstance("A")
        sut.addItem(itemA)
        sut.countOfItem() shouldBe 1

        should("삭제되면") {
           sut.removeItem(itemA)

           sut.countOfItem() shouldBe 0
        }
    }

    context("todoBoard 에 item A 가 존재하는데") {
        val sut = TodoBoard.newInstance()
        val itemA = TodoItem.newInstance("A")
        sut.addItem(itemA)

        should("존재하지 않는 item 을 삭제하려 한다면") {
            shouldThrow<IllegalStateException> {
                sut.removeItem(TodoItem.newInstance("B"))
            }
        }
    }

    context("todoBoard 에 item 이 존재하지 않을 때") {
        val sut = TodoBoard.newInstance()

        should("item 을 삭제하려 한다면") {
            shouldThrow<IllegalArgumentException> {
                sut.removeItem(TodoItem.newInstance("A"))
            }
        }
    }
})