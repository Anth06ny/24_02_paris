package com.example.a24_02_paris.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


fun main() {
    val res = WeatherAPI.loadWeather("Toulouse")
    println("Il fait ${res.main.temp}° à ${res.name} avec un vent de ${res.wind.speed} m/s")

}
object WeatherAPI {

    //Attribut instancié 1 seule fois car c'est un singleton
    //Et uniquement à la 1er utilisation (Lazy Loading)
    //private val client = OkHttpClient()

    //private val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.81.128.60", 8080))
    private val client = OkHttpClient() // OkHttpClient.Builder().proxy(proxy).build()
    val gson = Gson()

    const val URL_API = "https://api.openweathermap.org/data/2.5"

    fun loadWeather(cityName : String): WeatherBean {
        //Eventuel contrôle
        //Réaliser la requête.
        val json: String = sendGet(URL_API + "/weather?q=$cityName&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        //Parser le JSON avec le bon bean et GSON
        val data : WeatherBean = gson.fromJson(json, WeatherBean::class.java)

        //Eventuel contrôle ou extraction de données


        //Retourner la donnée
        return data
    }

    fun loadWeatherAround(cityName: String): List<WeatherBean> {
        //Réaliser la requête.
        val json: String = sendGet("https://api.openweathermap.org/data/2.5/find?q=$cityName&cnt=5&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        //Parser le JSON avec le bon bean et GSON
        val data  = gson.fromJson(json, WeatherAroundResult::class.java)

        //Retourner la donnée
        return data.list
    }

    fun sendGet(url: String): String {


        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use {
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}

/* -------------------------------- */
// Beans
/* -------------------------------- */
data class WeatherAroundResult(var list : List<WeatherBean>)

data class WeatherBean(var main : TempBean,var wind : WindBean,var name : String, var weather : List<DescriptionBean>)
data class TempBean(var temp: Double)
data class WindBean(var speed: Double)

data class DescriptionBean(
    var description: String,
    var icon: String,
    var main: String
)