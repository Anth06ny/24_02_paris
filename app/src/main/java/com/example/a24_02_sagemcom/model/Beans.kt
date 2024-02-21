package com.example.a24_02_sagemcom.model

import java.util.Random

var v1: String? = "toto"

fun main() {

    val t = ThermometerBean(1, 2, 3)
    val car = CarBean("ijkj", "jkj")


}

class ThermometerBean(val min: Int, val max: Int, value: Int) {

    var value = value.coerceIn(min, max)
        set(newValue) {
            field = newValue.coerceIn(min, max)
        }

    companion object {
        fun getCelsiusThermometer() = ThermometerBean(-30, 50, 0)
        fun getFahrenheitThermometer() = ThermometerBean(20, 120, 32)
    }
}

class PrintRandomIntBean(var max: Int) {
    private val random = Random()

    init {
        println("init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructor")
        println(random.nextInt(max))
    }

}

data class CarBean(var marque: String = "", var model: String? = null) {
    var color: String? = null

}