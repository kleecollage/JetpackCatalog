package com.example.jetpackcomosecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxGreen, boxBlue, boxYellow, boxMagenta, boxCyan) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(boxGreen.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                end.linkTo(parent.end)
                bottom.linkTo(boxGreen.top)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxGreen.top)
                start.linkTo(parent.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxGreen.bottom)
                end.linkTo(boxGreen.start)
            })
    }
}

@Composable
fun ContraintExample2() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        // val startGuide = createGuidelineFromTop(16.dp)

        val boxGreen = createRef()
        val topGuide = createGuidelineFromTop(0.1f) // 0.1f = 10%
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
    }
}

@Composable
fun ContraintBarrier() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxGreen, boxBlue, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxGreen, boxBlue)

    Box(modifier = Modifier
        .size(125.dp)
        .background(Color.Green)
        .constrainAs(boxGreen) {
            // top.linkTo(parent.top)
            // bottom.linkTo(parent.bottom)
            start.linkTo(parent.start, margin = 16.dp)
            // end.linkTo(parent.end)
        })
    Box(modifier = Modifier
        .size(225.dp)
        .background(Color.Blue)
        .constrainAs(boxBlue) {
            top.linkTo(boxGreen.bottom)
            start.linkTo(parent.start, margin = 32.dp)
        })
    Box(modifier = Modifier
        .size(50.dp)
        .background(Color.Yellow)
        .constrainAs(boxYellow) {
            start.linkTo(barrier)
        })
    }
}

@Preview
@Composable
fun ConstraintChainExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxGreen, boxBlue, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxBlue.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)
            })
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxBlue.end)
                end.linkTo(parent.end)
            })
        createHorizontalChain(boxGreen, boxBlue, boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}
























