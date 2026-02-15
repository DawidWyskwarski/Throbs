package com.example.throbs.tuner

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object TunerDestination

fun NavGraphBuilder.tunerScreen(
    onOpenDrawer: () -> Unit
) {
    composable<TunerDestination> {
        TunerScreen(
            onOpenDrawer = onOpenDrawer
        )
    }
}

fun NavController.navigateToTuner() {
    navigate(TunerDestination){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}