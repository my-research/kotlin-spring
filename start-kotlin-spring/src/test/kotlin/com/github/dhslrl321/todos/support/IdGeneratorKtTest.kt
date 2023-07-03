package com.github.dhslrl321.todos.support

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.ShouldSpec
import org.junit.jupiter.api.Assertions.*

class IdGeneratorKtTest: ShouldSpec({
    context("id 생성") {
        should("출력") {
            println(genId())
            println(genId())
            println(genId())
        }
    }
})