package com.example.jetpackcomosecatalogo.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Fort
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {
    Column {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        var realColor = if (firstColor) Color.Red else Color.Yellow

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        ) { }
        Spacer(modifier = Modifier.size(200.dp))

        var secondColor by rememberSaveable { mutableStateOf(false) }
        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Yellow)

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondColor = !secondColor }
        ) { }
    }
}

@Composable
fun ColorAnimationSimple2() {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    var showBox by rememberSaveable { mutableStateOf(true) }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )

    if (showBox) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        ) { }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 100.dp else 250.dp,
        animationSpec = tween(durationMillis = 1500),
        finishedListener = {
            if (!smallSize) {
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Cyan)
                .clickable { smallSize = !smallSize }
        ) { }
    }

}

@Composable
fun VisibilityAnimation() {
    var isVisible by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(isVisible) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
            ) {}
        }
    }
}

@Composable
fun VisibilityAnimation2() {
    var isVisible by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally(),
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
            ) {}
        }
    }
}

@Composable
fun CrossfadeExampleAnimation() {
    var myComponentType: ComponentType by remember { mutableStateOf(ComponentType.Text) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType) { myComponentType ->
            when (myComponentType) {
                ComponentType.Image -> Icon(Icons.Outlined.Fort, contentDescription = "Fort")
                ComponentType.Text -> Text(text = "Soy un componente")
                ComponentType.Box -> Box(Modifier.size(150.dp).background(Color.DarkGray))
                ComponentType.Error -> Text(text = "Error")
            }
        }
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when(nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType() { Text, Image, Box, Error }











