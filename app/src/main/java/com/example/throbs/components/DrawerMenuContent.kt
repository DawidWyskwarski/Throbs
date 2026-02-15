package com.example.throbs.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.MonitorHeart
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.throbs.learningQueue.LearningQueueDestination
import com.example.throbs.metronome.MetronomeDestination
import com.example.throbs.recorder.RecorderDestination
import com.example.throbs.tuner.TunerDestination

@Composable
fun DrawerMenuContent(
    modifier: Modifier = Modifier,
    selectedDestination: NavDestination?,
    navigateToTuner: () -> Unit,
    navigateToMetronome: () -> Unit,
    navigateToRecorder: () -> Unit,
    navigateToLearningQueue: () -> Unit,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Throbs",
                style = MaterialTheme.typography.headlineLarge,
            )

            // Tuner
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.MusicNote,
                        contentDescription = "Icon for tuner"
                    )
                },
                label = { Text( "Tuner" ) },
                selected = selectedDestination?.hierarchy?.any { it.hasRoute<TunerDestination>() } == true,
                onClick = {
                    navigateToTuner()
                    closeDrawer()
                }
            )

            // Metronome
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.MonitorHeart,
                        contentDescription = "Icon for metronome"
                    )
                },
                label = { Text( "Metronome" ) },
                selected = selectedDestination?.hierarchy?.any { it.hasRoute<MetronomeDestination>() } == true,
                onClick = {
                    navigateToMetronome()
                    closeDrawer()
                }
            )

            // Recorder
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Mic,
                        contentDescription = "Icon for Recorder"
                    )
                },
                label = { Text( "Recorder" ) },
                selected = selectedDestination?.hierarchy?.any { it.hasRoute<RecorderDestination>() } == true,
                onClick = {
                    navigateToRecorder()
                    closeDrawer()
                }
            )

            // Learning Queue
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Album,
                        contentDescription = "Icon for Learning Queue"
                    )
                },
                label = { Text( "Learning Queue" ) },
                selected = selectedDestination?.hierarchy?.any { it.hasRoute<LearningQueueDestination>() } == true,
                onClick = {
                    navigateToLearningQueue()
                    closeDrawer()
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Settings
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = "Icon for Settings"
                    )
                },
                label = { Text( "Settings" ) },
                selected = false,
                onClick = {
                    closeDrawer()
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )

            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.StarRate,
                        contentDescription = "Icon for Rating"
                    )
                },
                label = { Text( "Rate Us On Play Store" ) },
                selected = false,
                onClick = {
                    closeDrawer()
                }
            )

            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = "Icon for Sharing"
                    )
                },
                label = { Text( "Share Our App" ) },
                selected = false,
                onClick = {
                    closeDrawer()
                }
            )
        }
    }
}

