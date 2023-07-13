package com.github.dhslrl321.todos.domain

import com.github.dhslrl321.todos.domain.core.TodoBoard
import com.github.dhslrl321.todos.domain.core.TodoItem
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class Create_Add_Item_TodoBoardTest : ShouldSpec({
    context("todoBoard 가 생성되고") {
        val actual = TodoBoard.newInstance()

        should("todoItem 이 보드에 추가될 수 있다") {

            val item1 = TodoItem.newInstance("밥먹기")
            val item2 = TodoItem.newInstance("잠자기")

            actual.addItem(item1)
            actual.addItem(item2)

            actual.countOfItem() shouldBe 2
        }

        should("동일한 todoItem 이 보드에 추가되면 예외가 발생된다") {
            val item1 = TodoItem.newInstance("밥먹기")

            val exception = shouldThrow<IllegalArgumentException> {
                actual.addItem(item1)
                actual.addItem(item1)
            }

            exception.message shouldBe "중복되는 todoItem 은 추가될 수 없습니다"
        }
    }
})