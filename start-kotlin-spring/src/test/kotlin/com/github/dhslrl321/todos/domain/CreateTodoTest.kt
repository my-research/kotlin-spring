package com.github.dhslrl321.todos.domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class CreateTodoTest : ShouldSpec({
    context("todo 가 생성되면") {
        val actual = TodoItem.newInstance("name")

        should("상태는 CREATED 여야 한다") {
            actual.status shouldBe TodoStatus.CREATED
        }
    }
})