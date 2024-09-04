package com.meuplantao.screen.home

import ColorPickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.meuplantao.util.extensions.toColor


@Composable
fun HomeScreen(navigateToDetails: () -> Unit) {
    var show by remember { mutableStateOf(false) }
    var color by remember { mutableStateOf("#000000") }

    if (show) {
        ColorPickerDialog(
            initialColor = "#AAAAAA",
            colors = listOf(
                "#FF0000", "#00FF00", "#0000FF",
                "#FFFF00", "#FF00FF", "#00FFFF",
                "#000000", "#FFFFFF", "#FFA500"
            ),
            onChoice = {
                color = it
                show = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = androidx.compose.material.MaterialTheme.typography.h6
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Button(
                onClick = {
                    show = true
                }
            ) {
                Text(
                    text = "Ver",
                    style = androidx.compose.material.MaterialTheme.typography.button
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(color.toColor(Color.White))
            )
        }
    }
}
