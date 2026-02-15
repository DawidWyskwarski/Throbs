package com.example.throbs

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.throbs.components.DrawerMenuContent
import com.example.throbs.learningQueue.learningQueueScreen
import com.example.throbs.learningQueue.navigateToLearningQueue
import com.example.throbs.metronome.metronomeScreen
import com.example.throbs.metronome.navigateToMetronome
import com.example.throbs.recorder.navigateToRecorder
import com.example.throbs.recorder.recorderScreen
import com.example.throbs.tuner.TunerDestination
import com.example.throbs.tuner.navigateToTuner
import com.example.throbs.tuner.tunerScreen
import kotlinx.coroutines.launch

@Composable
fun AppRoot() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenuContent(
                selectedDestination = currentDestination,
                navigateToTuner = { navController.navigateToTuner() },
                navigateToMetronome = { navController.navigateToMetronome() },
                navigateToRecorder = { navController.navigateToRecorder() },
                navigateToLearningQueue = { navController.navigateToLearningQueue() },
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = TunerDestination,
        ) {
            val openDrawer: () -> Unit = {
                scope.launch {
                    drawerState.open()
                }
            }

            tunerScreen(onOpenDrawer = openDrawer)
            metronomeScreen(onOpenDrawer = openDrawer)
            recorderScreen(onOpenDrawer = openDrawer)
            learningQueueScreen(onOpenDrawer = openDrawer)
        }
    }
}
