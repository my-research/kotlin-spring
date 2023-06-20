package com.github.dhslrl321.todos.support

import java.time.Instant

fun genId(): Long = timestampWithRandom2Number().toLong()

private fun timestampWithRandom2Number() =
    "${Instant.now().toEpochMilli()}" + "${(1..10).random()}" + "${(1..10).random()}"