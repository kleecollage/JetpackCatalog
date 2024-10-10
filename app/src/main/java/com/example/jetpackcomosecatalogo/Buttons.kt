package com.example.jetpackcomosecatalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Festival
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.LightGray
        )

    ) {
        Text(text = "Mi Boton")
    }
}

@Composable
fun MyFilledButton() {
    FilledTonalButton(
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            contentColor = Color.Black,
            containerColor = Color.LightGray
        )
    ) {
        Text(text = "Mi Boton Filled")
    }
}

@Composable
fun MyElevatedButton() {
    ElevatedButton(
        onClick = {},
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            contentColor = Color.Black,
            containerColor = Color.LightGray
        )
    ) {
        Text(text = "My Elevated Button")
    }
}

@Composable
fun MyFABs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        SmallFloatingActionButton(
            onClick = {},
            containerColor = Color.LightGray,
            contentColor = Color.Red,
        ) {
            Icon(imageVector = Icons.Default.HealthAndSafety, contentDescription = "FAB")
        }

        Spacer(modifier = Modifier.height(10.dp))

        FloatingActionButton(
            onClick = {},
            containerColor = Color.Red,
            contentColor = Color.Black,
        ) {
            Icon(imageVector = Icons.Default.HeartBroken, contentDescription = "FAB")
        }

        Spacer(modifier = Modifier.height(10.dp))

        LargeFloatingActionButton(
            onClick = {},
            containerColor = Color.DarkGray,
            contentColor = Color.Green,
        ) {
            Icon(imageVector = Icons.Default.Adb, contentDescription = "FAB", Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))

        ExtendedFloatingActionButton(
            onClick = {},
            containerColor = Color.Yellow,
            contentColor = Color.Blue,
            text = { Text( text = "Hola Mundo")},
            icon = { Icon(Icons.Filled.Festival, contentDescription = "Extended FAB") }
        )




    }
}