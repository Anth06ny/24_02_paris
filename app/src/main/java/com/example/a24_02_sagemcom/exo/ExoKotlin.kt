package com.example.a24_02_sagemcom.exo

import com.example.a24_02_sagemcom.PlaneBean

fun main() {

    val nbB = scanNumber("Donnez un nombre de baguette : ")

    println(boulangerie(nbB = nbB)) //  boulangerie(0 , 5, 5)

    val plane = PlaneBean("toto")

    var res = plane.name

}

fun scanText(question : String) : String {
    print(question)
    return readlnOrNull() ?: "-"
}

fun scanNumber(question:String) : Int = scanText(question).toIntOrNull() ?: 0

fun boulangerie(nbC : Int = 0, nbB:Int = 0, nbS : Int = 0) =
    nbC * PRICE_CROISSANT + nbB * PRIX_BAGUETTE + nbS * PRIX_SANDWITCH





fun min(a:Int, b:Int) = if(a <= b) a else b

fun pair(c:Int) = c%2 == 0

fun myPrint(text : String) = println("#$text#")


