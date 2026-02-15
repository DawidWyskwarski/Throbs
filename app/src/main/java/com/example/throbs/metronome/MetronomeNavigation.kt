package com.example.throbs.metronome

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object MetronomeDestination

fun NavGraphBuilder.metronomeScreen(
    onOpenDrawer: () -> Unit
) {
    composable<MetronomeDestination> {
        MetronomeScreen(
            onOpenDrawer = onOpenDrawer
        )
    }
}

fun NavController.navigateToMetronome() {
    navigate(MetronomeDestination){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}