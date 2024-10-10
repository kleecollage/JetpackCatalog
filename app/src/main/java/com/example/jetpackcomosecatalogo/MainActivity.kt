package com.example.jetpackcomosecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomosecatalogo.ui.theme.CheckInfo
import com.example.jetpackcomosecatalogo.ui.theme.CrossfadeExampleAnimation
import com.example.jetpackcomosecatalogo.ui.theme.JetpackComoseCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComoseCatalogoTheme {
                CrossfadeExampleAnimation()
            }

            /*
            val navigationController = rememberNavController()

            NavHost(
                navController = navigationController,
                startDestination = Routes.Pantalla1.route
            ) {
                composable(Routes.Pantalla1.route) { Screen1(navigationController) }

                composable(Routes.Pantalla2.route) { Screen2(navigationController) }

                composable(Routes.Pantalla3.route) { Screen3(navigationController) }

                composable(
                    Routes.Pantalla4.route,
                    arguments = listOf(navArgument("age") {type = NavType.IntType} )
                ) { backStackEntry ->
                    val argument = backStackEntry.arguments?.getInt("age") ?: 0
                    Screen4(navigationController, argument)
                }

                composable(
                    Routes.Pantalla5.route,
                    arguments = listOf(navArgument("name") { defaultValue = "KleeCollage"} )
                ) { backStackEntry ->
                    val arguments = backStackEntry.arguments?.getString("name")
                    Screen5(navigationController, arguments)
                }


            var show by remember { mutableStateOf(false) }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = { show = true }) {
                    Text(text = "Show AlertDialog")
                }
                MyConfirmationDialog(
                    show = show,
                    onDismiss = { show = false }
                )

                MyCustomDialog(
                    show = show,
                    onDismiss = { show = false }
                )

                MySimpleCustomDialog(
                    show = show,
                    onDismiss = { show = false }
                )

                MyAlertDialog (
                    show = show,
                    onDismiss = { show = false },
                    onConfirm = { Log.i("Klee", "click") })
            }

            val myOptions = getOptions(listOf("Xbox", "PS5", "Nintendo"))
            var selected by remember { mutableStateOf("Xbox") }
            */
        }
    }
}


@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Helado", "Pastel", "Chocolate", "Pay", "Galletas", "Dona")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = dessert
                        expanded = false
                    },
                    text = { Text(dessert) },
                    /*                    modifier = TODO(),
                                        leadingIcon = TODO(),
                                        trailingIcon = TODO(),
                                        enabled = TODO(),
                                        colors = TODO(),
                                        contentPadding = TODO(),
                                        interactionSource = TODO(),*/
                )
            }
        }
    }
}

@Composable
fun MyDivider() {
    HorizontalDivider(Modifier.fillMaxWidth(), color = Color.Black)
}

@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Badge(containerColor = Color.Blue, contentColor = Color.Green) {
                Text(text = "100")
            }
        }
    ) {
        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Blue
        ),
        border = BorderStroke(5.dp, Color.Black)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Texto 1")
            Text(text = "Texto 2")
            Text(text = "Texto 3")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(
        Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            selected = false,
            onClick = { },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Magenta,
                disabledSelectedColor = Color.Green
            ),
        )
        Text(text = "Hola Mundo")
    }

}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(selected = name == "Xbox", onClick = { onItemSelected("Xbox") })
            Text(text = "Xbox")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(selected = name == "PS5", onClick = { onItemSelected("PS5") })
            Text(text = "PS5")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(selected = name == "Nintendo", onClick = { onItemSelected("Nintendo") })
            Text(text = "Nintendo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            RadioButton(selected = name == "Switch", onClick = { onItemSelected("Switch") })
            Text(text = "Switch")
        }
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row() {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Hola Mundo")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Blue,
                checkmarkColor = Color.Green,
            )
        )
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Cyan.copy(alpha = 0.5f),

                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Magenta.copy(alpha = 0.2f),

                disabledCheckedTrackColor = Color.Yellow,
                disabledCheckedThumbColor = Color.Yellow,

                disabledUncheckedTrackColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Yellow,
            )
        )
    }
}

@Composable
fun MyProgressAdvanced() {
    var progressStatus by remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = { progressStatus },
        )

        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progressStatus += 0.1f }, Modifier.padding(end = 100.dp)) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Black, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Pulsa Aqui")
        }
    }
}

@Composable
fun MyIcon() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = "Icono",
            tint = Color.Red
        )
    }
}

@Composable
fun MyImageAdvanced() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.elitebabe),
            contentDescription = "Imagen android",
            // modifier = Modifier.clip(RoundedCornerShape(25f))
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Black, CircleShape)
        )
    }
}

@Composable
fun MyImage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Ejemplo de imagen",
            alpha = 0.9f
        )
    }
}

@Composable
fun MyButtonExample() {
    var enabled by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola mundo")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.LightGray,
            )
        ) {
            Text(text = "Boton Outlined")
        }

        TextButton(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Text Button")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    Column(Modifier.fillMaxSize()) {
        var myText by remember { mutableStateOf("") }
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier = Modifier.padding(24.dp),
            label = { Text(text = "Hola mundo") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue,
                cursorColor = Color.Magenta,
                focusedLabelColor = Color.Magenta,
                unfocusedLabelColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyTextFieldAdvanced() {
    Column(Modifier.fillMaxSize()) {
        var myText by remember { mutableStateOf("") }
        TextField(
            value = myText,
            onValueChange = {
                myText =
                    if (it.contains(("a"))) {
                        it.replace("a", "")
                    } else {
                        it
                    }
            },
            label = { Text(text = "Introduce tu nombre") })
    }
}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // var myText by remember { mutableStateOf("KleeColalge") }
        // TextField(value = myText, onValueChange = { myText = it })
        TextField(value = name, onValueChange = { it })
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es el ejemplo mas basico")
        Text(text = "Esto es un cambio de color", color = Color.Blue)
        Text(text = "Esto es un cambio de fuente", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un cambio de fuente", fontWeight = FontWeight.Light)
        Text(text = "Esto es un cambio de estilo", fontFamily = FontFamily.Monospace)
        Text(
            text = "Esto es un cambio de estilo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es cambio de tamaño", fontSize = 30.sp)
    }
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "PULSAR")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Columna de Ejemplo 1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Columna de Ejemplo 1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text("Columna de Ejemplo 2", modifier = Modifier.background(Color.Blue))
        Text("Columna de Ejemplo 3", modifier = Modifier.background(Color.Yellow))
        Text("Columna de Ejemplo 4", modifier = Modifier.background(Color.Green))
        Text("Columna de Ejemplo 5", modifier = Modifier.background(Color.Magenta))
    }
}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Ejemplo de row 1", modifier = Modifier.width(100.dp))
        Text("Ejemplo de row 2", modifier = Modifier.width(100.dp))
        Text("Ejemplo de row 3", modifier = Modifier.width(100.dp))
        Text("Ejemplo de row 4", modifier = Modifier.width(100.dp))
        Text("Ejemplo de row 5", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        ) {}
        MySpacer(10)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Yellow)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center
            ) {
                Text("Hola soy el segundo Box y estoy dentro de un Row dentro de un Column")
            }
        }
        MySpacer(20)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green)
        )
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text("Esto es un Ejemplo")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Preview(showBackground = true)
@Composable
fun MyBoxPreview() {
    JetpackComoseCatalogoTheme {
        // MyDialog(true, {}, {})
    }
}
