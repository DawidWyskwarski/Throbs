package com.example.throbs.learningQueue

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object LearningQueueDestination

fun NavGraphBuilder.learningQueueScreen(
    onOpenDrawer: () -> Unit
) {
     composable<LearningQueueDestination> {
        LearningQueueScreen(
            onOpenDrawer = onOpenDrawer
        )
    }
}

fun NavController.navigateToLearningQueue() {
    navigate(LearningQueueDestination){
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}