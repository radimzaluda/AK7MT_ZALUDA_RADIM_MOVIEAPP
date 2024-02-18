package com.example.ak7mt_zaluda_radim_movieapp.core

import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import android.os.Bundle
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
//import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.compose.NavHost
import com.example.ak7mt_zaluda_radim_movieapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.ak7mt_zaluda_radim_movieapp.movieList.util.Screen


//import java.lang.reflect.Modifier


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{


MoviesAppTheme {
//    SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

       val navController = rememberNavController()

        NavHost(navController = navController,
          startDestination = Screen.Home.rout
            ){

        }



    }

}
        }

    }
}