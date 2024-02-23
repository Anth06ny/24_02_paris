package com.example.a24_02_paris.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val searchText = mutableStateOf("")
    val myList = mutableStateListOf<PictureBean>()
    var runInProgress by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun uploadSearchText(newText : String){
        searchText.value = newText
    }

    fun loadData() {//Simulation de chargement de donnée
        myList.clear()

        runInProgress = true
        errorMessage = ""

        viewModelScope.launch(Dispatchers.Default) {

            try {
                val res: List<WeatherBean> = WeatherAPI.loadWeatherAround("Toulouse")

                val listPicture = res.map {
                    PictureBean(
                        it.hashCode(), "https://openweathermap.org/img/wn/${it.weather.getOrNull(0)?.icon}@4x.png", it.name,
                        "Il fait ${it.main.temp}° à ${it.name} avec un vent de ${it.wind.speed} m/s"
                    )
                }
                myList.addAll(listPicture) //Charge la liste en mode mélangé

            }
            catch (e:Exception){
                e.printStackTrace()
                errorMessage = "Une erreur : ${e.message}"
            }
            runInProgress = false
        }
        //Thread.sleep(1000) //simule temps de la requête
    }
}