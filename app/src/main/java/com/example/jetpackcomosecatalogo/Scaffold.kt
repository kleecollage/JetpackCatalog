package com.example.jetpackcomosecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.EditRoad
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Sailing
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val scope = rememberCoroutineScope()
    val scaffoldState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = { MyDrawer(onCloseDrawer = { scope.launch { drawerState.close() }}) },
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar (
                    onClickIcon = { scope.launch {
                        scaffoldState.showSnackbar("Has pulsado $it", "DESHACER")
                    }},
                    onLickDrawer = { scope.launch { drawerState.open() } }
                )
            },
            snackbarHost = { SnackbarHost(hostState = scaffoldState) },
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center,

            /* CONTENT */
        ) { paddingValues ->
            Text(
                text = "Contenido Principal",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar( onClickIcon: (String) -> Unit, onLickDrawer: () -> Unit ) {
    TopAppBar(
        title = { Text(text = "Top App Bar Title") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onLickDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Sidebar Menu",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search anything") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    tint = Color.White
                )
            }
            IconButton(onClick = { onClickIcon("Warning, Danger Zone") }) {
                Icon(
                    imageVector = Icons.Filled.Dangerous,
                    contentDescription = "dangerous",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableIntStateOf(0) }
    NavigationBar(containerColor = Color.Black) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Filled.Hub, contentDescription = "Hub") },
            label = { Text(text="HUB")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.LightGray
            )
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Filled.EditRoad, contentDescription = "EditRoad") },
            label = { Text(text="EditRoad")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.LightGray
            )
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Filled.Sailing, contentDescription = "Sailing") },
            label = { Text(text="Sailing")},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.LightGray
            )
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.LightGray,
        contentColor = Color.Black
        ) {
        Icon(imageVector = Icons.Filled.Adb, contentDescription = "FAB")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit ) {
    Column(Modifier.padding(8.dp).background(Color.White)) {
        Text(
            text  = "Primera opcion",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text  = "Segunda opcion",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text  = "Tercera opcion",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text  = "Cuarta opcion",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text  = "Quinta opcion",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
    }
}
















