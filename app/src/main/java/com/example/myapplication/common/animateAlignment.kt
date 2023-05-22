package com.example.myapplication.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment

@Composable
fun AnimateAlignmentAsState(
    targetAlignment: Alignment,
): Alignment {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias)
    val vertical by animateFloatAsState(biased.verticalBias)
    return BiasAlignment(horizontal, vertical)
}
