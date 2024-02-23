package com.example.a24_02_paris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a24_02_paris.model.MainViewModel
import com.example.a24_02_paris.model.PictureBean
import com.example.a24_02_paris.ui.screens.DetailScreen
import com.example.a24_02_paris.ui.screens.SearchScreen
import com.example.a24_02_paris.ui.theme._24_02_parisTheme

class ComposeExActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _24_02_parisTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

sealed class Routes(val route: String) {
    object SearchScreen : Routes("searchScreen")
    object DetailScreen : Routes("detailScreen/{id}") {
        fun withId(id: Int) = "detailScreen/$id"
        fun withObject(data : PictureBean) = "detailScreen/${data.id}"
    }
}

@Composable
fun AppNavigation() {

    val navController: NavHostController = rememberNavController()

    val viewModel : MainViewModel = viewModel()



    NavHost(navController = navController, startDestination = Routes.SearchScreen.route) {
        //Route 1
        composable(Routes.SearchScreen.route) {
            SearchScreen(navController, viewModel = viewModel)
        }

        //Route 2
        composable(
            route = Routes.DetailScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id") ?: 1
            DetailScreen(idPicture = id, navController = navController, viewModel =  viewModel)
        }
    }
}