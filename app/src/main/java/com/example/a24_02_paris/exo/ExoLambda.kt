package com.example.a24_02_paris.exo

fun main() {
    exo2()
}

data class UserBean(var name: String, var old: Int) {
}

fun exo2() {
    val compareUsersByName: (UserBean, UserBean) -> UserBean = { u1, u2 -> if (u1.name.lowercase() <= u2.name.lowercase()) u1 else u2 }
    val compareUsersByOld: (UserBean, UserBean) -> UserBean = { u1, u2 -> if (u1.old > u2.old) u1 else u2 }

    val u1 = UserBean("Bob", 19)
    val u2 = UserBean("Toto", 45)
    val u3 = UserBean("Charles", 26)
    println(compareUsers(u1, u2, u3, compareUsersByName)) // UserBean(name=Bob old=19)
    println(compareUsers(u1, u2, u3, compareUsersByOld)) // UserBean(name=Toto old=45)

    val absTo30 : (UserBean)->Int = {Math.abs(30 - it.old)}

    val res = compareUsers(u1, u2, u3) { uA, uB -> if (Math.abs(30 - uA.old) < Math.abs(30 - uB.old)) uA else uB }

}

inline fun compareUsers(u1: UserBean, u2: UserBean, u3: UserBean, comparator: (UserBean, UserBean) -> UserBean) = comparator(comparator(u1, u2), u3)

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