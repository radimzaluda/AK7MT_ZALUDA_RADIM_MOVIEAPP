package com.example.ak7mt_zaluda_radim_movieapp.core

import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import android.os.Bundle
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
//import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ak7mt_zaluda_radim_movieapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.ak7mt_zaluda_radim_movieapp.movieList.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


//import java.lang.reflect.Modifier


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{


MoviesAppTheme {
   SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

       val navController = rememberNavController()

        NavHost(navController = navController,
          startDestination = Screen.Home.rout
            ){
            composable(Screen.Home.rout) {
                HomeScreen(navController)
            }

            composable(
                Screen.Details.rout + "/{movieId}",
                arguments = listOf(
                    navArgument("movieId") { type = NavType.IntType }
                )
            ) { backStackEntry ->
//                DetailsScreen()
            }
        }

    }
}
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(key1 = color) {
            systemUiController.setSystemBarsColor(color)
        }
    }
}