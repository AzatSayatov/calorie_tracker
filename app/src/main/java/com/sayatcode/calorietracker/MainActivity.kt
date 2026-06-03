package com.sayatcode.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sayatcode.calorietracker.ui.theme.CalorieTrackerTheme
import com.sayatcode.core.navigation.Route
import com.sayatcode.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Route.WELCOME) {
                    composable(Route.WELCOME){
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE){
                        Column(Modifier.fillMaxSize()) {
                            Text(text = "Age Page",
                                color = Color.White
                            )
                        }
                    }
                    composable(Route.HEIGHT){

                    }
                    composable(Route.WEIGHT){

                    }
                    composable(Route.GENDER){

                    }
                    composable(Route.NUTRIENT_GOAL){

                    }
                    composable(Route.GOAL){

                    }
                    composable(Route.ACTIVITY){

                    }
                    composable(Route.TRACKER_OVERVIEW){

                    }
                    composable(Route.SEARCH){

                    }
                }
            }
        }
    }
}