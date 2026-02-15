package com.example.throbs.recorder

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object RecorderDestination

fun NavGraphBuilder.recorderScreen(
    onOpenDrawer: () -> Unit
) {
    composable<RecorderDestination> {
        RecorderScreen(
            onOpenDrawer = onOpenDrawer
        )
    }
}

fun NavController.navigateToRecorder() {
    navigate(RecorderDestination) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}