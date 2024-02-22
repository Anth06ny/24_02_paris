package com.example.a24_02_paris.exo

fun main() {
    exo1()
}

fun exo1() {
    var lower: (String) -> Unit = {
        println(it)
    }

    lower("Coucou")

    var hour: (Int) -> Int = { it / 60 }

    var max: (Int, Int) -> Int = { a, b -> Math.max(a, b) }
    var reverse: (String) -> String = { it.reversed() }


    var minToMinHour: ((Int?) -> Pair<Int, Int>?)? = {
        if (it != null) Pair(hour(it), it % 60) else null
    }

    repeat(5) {

    }

    minToMinHour?.let { it(5) }
}