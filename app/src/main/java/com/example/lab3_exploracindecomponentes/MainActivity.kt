package com.example.lab3_exploracindecomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.lab3_exploracindecomponentes.ui.theme.LAB3_ExploraciónDeComponentesTheme
import kotlinx.coroutines.launch

val Dorado = Color(0xFFF0A020)
val DoradoSuave = Color(0xFFE7B76A)
val Negro = Color.Black.copy(alpha = 0.82f)
val NegroSuave = Color.Black.copy(alpha = 0.68f)
val Blanco = Color.White
val GrisClaro = Color(0xFFCCCCCC)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LAB3_ExploraciónDeComponentesTheme {
                ExploradorComponentes()
            }
        }
    }
}

@Composable
fun FondoAorus(
    contenido: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.aorus),
            contentDescription = "Fondo Aorus",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.20f))
        )

        contenido()
    }
}

@Composable
fun TituloEjemplo(titulo: String) {

    Text(
        text = titulo,
        color = Dorado,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(12.dp)
    )
}

@Composable
fun BotonDorado(
    texto: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Dorado
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Negro,
            contentColor = Blanco
        )
    ) {

        Text(
            text = texto,
            color = Blanco,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TarjetaDorada(
    texto: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Negro
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Dorado
        )
    ) {

        Text(
            text = texto,
            color = Blanco,
            fontSize = 18.sp,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun ExploradorComponentes() {

    val componentes = listOf(
        "LazyColumn",
        "LazyRow",
        "Grid",
        "ConstraintLayout",
        "Scaffold",
        "Surface",
        "Chip",
        "BackdropScaffold",
        "FlowRow",
        "FlowColumn",
        "AlertDialog",
        "Card",
        "Checkbox",
        "FloatingActionButton",
        "Icon",
        "Image",
        "ProgressBar",
        "RadioButton",
        "Slider",
        "Spacer",
        "Switch",
        "TopAppBar",
        "BottomNavigation",
        "Dialog",
        "Divider",
        "DropDownMenu",
        "LazyVerticalGrid",
        "NavigationRail",
        "OutlinedTextField",
        "Pager",
        "Snackbar",
        "TabRow",
        "Tooltip"
    )

    var seleccionado by remember {
        mutableStateOf("LazyColumn")
    }

    FondoAorus {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 35.dp)
        ) {

            Text(
                text = "EXPLORACIÓN DE\nCOMPONENTES",
                color = Dorado,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 10.dp
                )
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                items(componentes) { nombre ->

                    Button(
                        onClick = {
                            seleccionado = nombre
                        },
                        modifier = Modifier
                            .padding(4.dp)
                            .height(58.dp),
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Dorado
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Negro,
                            contentColor = Blanco
                        )
                    ) {

                        Text(
                            text = nombre,
                            color = if (seleccionado == nombre) {
                                Dorado
                            } else {
                                Blanco
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {

                when (seleccionado) {

                    "LazyColumn" -> EjemploLazyColumn()
                    "LazyRow" -> EjemploLazyRow()
                    "Grid" -> EjemploGrid()
                    "ConstraintLayout" -> EjemploConstraintLayout()
                    "Scaffold" -> EjemploScaffold()
                    "Surface" -> EjemploSurface()
                    "Chip" -> EjemploChip()
                    "BackdropScaffold" -> EjemploBackdropScaffold()
                    "FlowRow" -> EjemploFlowRow()
                    "FlowColumn" -> EjemploFlowColumn()
                    "AlertDialog" -> EjemploAlertDialog()
                    "Card" -> EjemploCard()
                    "Checkbox" -> EjemploCheckbox()
                    "FloatingActionButton" -> EjemploFloatingActionButton()
                    "Icon" -> EjemploIcon()
                    "Image" -> EjemploImage()
                    "ProgressBar" -> EjemploProgressBar()
                    "RadioButton" -> EjemploRadioButton()
                    "Slider" -> EjemploSlider()
                    "Spacer" -> EjemploSpacer()
                    "Switch" -> EjemploSwitch()
                    "TopAppBar" -> EjemploTopAppBar()
                    "BottomNavigation" -> EjemploBottomNavigation()
                    "Dialog" -> EjemploDialog()
                    "Divider" -> EjemploDivider()
                    "DropDownMenu" -> EjemploDropDownMenu()
                    "LazyVerticalGrid" -> EjemploLazyVerticalGrid()
                    "NavigationRail" -> EjemploNavigationRail()
                    "OutlinedTextField" -> EjemploOutlinedTextField()
                    "Pager" -> EjemploPager()
                    "Snackbar" -> EjemploSnackbar()
                    "TabRow" -> EjemploTabRow()
                    "Tooltip" -> EjemploTooltip()
                }
            }
        }
    }
}

@Composable
fun EjemploLazyColumn() {

    val datos = listOf(
        "Android",
        "Kotlin",
        "Compose",
        "Git",
        "GitHub"
    )

    Column {

        TituloEjemplo("LazyColumn")

        LazyColumn {

            items(datos) { elemento ->

                    TarjetaDorada(
                        texto = elemento,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                }
            }
        }
    }

@Composable
fun EjemploLazyRow() {

    val datos = listOf(
        "Kotlin",
        "Android",
        "Compose",
        "Git",
        "GitHub"
    )

    Column {

        TituloEjemplo("LazyRow")

        LazyRow {

            items(datos) { elemento ->


                    TarjetaDorada(
                        texto = elemento,
                        modifier = Modifier
                            .width(160.dp)
                            .padding(5.dp)
                    )
                }
            }
        }
    }


@Composable
fun EjemploGrid() {

    val datos = listOf(
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Cinco",
        "Seis"
    )

    Column {

        TituloEjemplo("Grid")

        datos.chunked(2).forEach { fila ->

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                fila.forEach { dato ->

                    TarjetaDorada(
                        texto = dato,
                        modifier = Modifier
                            .weight(1f)
                            .height(95.dp)
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun EjemploConstraintLayout() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {

        val (titulo, boton) = createRefs()

        Text(
            text = "ConstraintLayout",
            color = Dorado,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(titulo) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(boton) {
                top.linkTo(titulo.bottom, 30.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            shape = RoundedCornerShape(14.dp),
            border = BorderStroke(1.dp, Dorado),
            colors = ButtonDefaults.buttonColors(
                containerColor = Negro,
                contentColor = Blanco
            )
        ) {

            Text(
                text = "Botón",
                color = Blanco,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun EjemploScaffold() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {

            Surface(
                color = Negro,
                border = BorderStroke(
                    width = 1.dp,
                    color = Dorado
                )
            ) {

                Text(
                    text = "Scaffold",
                    color = Dorado,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) { padding ->

        TarjetaDorada(
            texto = "Contenido principal del Scaffold",
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
                .padding(20.dp)
        )
    }
}

@Composable
fun EjemploSurface() {

    Column {

        TituloEjemplo("Surface")

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(16.dp),
            color = Negro,
            contentColor = Blanco,
            border = BorderStroke(
                width = 1.dp,
                color = Dorado
            )
        ) {

            Text(
                text = "Ejemplo de Surface",
                color = Blanco,
                fontSize = 18.sp,
                modifier = Modifier.padding(30.dp)
            )
        }
    }
}

@Composable
fun EjemploChip() {

    Column {

        TituloEjemplo("Chip")

        AssistChip(
            onClick = {},
            label = {

                Text(
                    text = "Android",
                    color = Blanco,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = AssistChipDefaults.assistChipColors(
                containerColor = Negro,
                labelColor = Blanco
            ),
            border = AssistChipDefaults.assistChipBorder(
                enabled = true,
                borderColor = Dorado
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploBackdropScaffold() {

    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        sheetContainerColor = Negro,
        sheetContentColor = Blanco,
        sheetDragHandle = {

            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .width(50.dp)
                    .height(4.dp),
                color = Dorado,
                shape = RoundedCornerShape(20.dp)
            ) {}
        },
        sheetContent = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp)
            ) {

                Text(
                    text = "Panel secundario",
                    color = Dorado,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Ejemplo moderno de BackdropScaffold mediante BottomSheetScaffold.",
                    color = Blanco
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            TituloEjemplo(
                "BackdropScaffold / BottomSheetScaffold"
            )

            TarjetaDorada(
                texto = "Contenido principal",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowRow() {

    Column {

        TituloEjemplo("FlowRow")

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            repeat(6) {

                BotonDorado(
                    texto = "Item ${it + 1}",
                    onClick = {}
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowColumn() {

    Column {

        TituloEjemplo("FlowColumn")

        FlowColumn(
            modifier = Modifier.height(280.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            repeat(5) {

                BotonDorado(
                    texto = "Item ${it + 1}",
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun EjemploAlertDialog() {

    var mostrar by remember {
        mutableStateOf(false)
    }

    Column {

        TituloEjemplo("AlertDialog")

        BotonDorado(
            texto = "Mostrar alerta",
            onClick = {
                mostrar = true
            }
        )

        if (mostrar) {

            AlertDialog(
                onDismissRequest = {
                    mostrar = false
                },
                containerColor = Color(0xFF111111),
                titleContentColor = Dorado,
                textContentColor = Blanco,
                title = {

                    Text(
                        text = "Alerta",
                        color = Dorado,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {

                    Text(
                        text = "Este es un ejemplo de AlertDialog",
                        color = Blanco
                    )
                },
                confirmButton = {

                    TextButton(
                        onClick = {
                            mostrar = false
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Dorado
                        )
                    ) {

                        Text(
                            text = "Aceptar",
                            color = Dorado
                        )
                    }
                },
                dismissButton = {

                    TextButton(
                        onClick = {
                            mostrar = false
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Blanco
                        )
                    ) {

                        Text(
                            text = "Cancelar",
                            color = Blanco
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun EjemploCard() {

    Column {

        TituloEjemplo("Card")

        TarjetaDorada(
            texto = "Tarjeta Jetpack Compose",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun EjemploCheckbox() {

    var marcado by remember {
        mutableStateOf(false)
    }

    Column {

        TituloEjemplo("Checkbox")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = marcado,
                onCheckedChange = {
                    marcado = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Dorado,
                    uncheckedColor = Dorado,
                    checkmarkColor = Color.Black
                )
            )

            Text(
                text = "Aceptar términos",
                color = Blanco,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun EjemploFloatingActionButton() {

    Column {

        TituloEjemplo("FloatingActionButton")

        FloatingActionButton(
            onClick = {},
            containerColor = Negro,
            contentColor = Dorado,
            shape = RoundedCornerShape(18.dp)
        ) {

            Text(
                text = "+",
                color = Dorado,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun EjemploIcon() {

    Column {

        TituloEjemplo("Icon")

        Surface(
            color = Negro,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Dorado),
            modifier = Modifier.padding(10.dp)
        ) {

            Icon(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = "Android",
                tint = Dorado,
                modifier = Modifier
                    .padding(20.dp)
                    .size(100.dp)
            )
        }
    }
}

@Composable
fun EjemploImage() {

    Column {

        TituloEjemplo("Image")

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Negro
            ),
            border = BorderStroke(1.dp, Dorado),
            modifier = Modifier.padding(10.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.aorus),
                contentDescription = "Imagen Aorus",
                modifier = Modifier
                    .padding(6.dp)
                    .size(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun EjemploProgressBar() {

    Column {

        TituloEjemplo("ProgressBar")

        LinearProgressIndicator(
            progress = { 0.70f },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .padding(horizontal = 15.dp),
            color = Dorado,
            trackColor = Negro
        )

        Text(
            text = "70%",
            color = Blanco,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun EjemploRadioButton() {

    var opcion by remember {
        mutableStateOf("Android")
    }

    Column {

        TituloEjemplo("RadioButton")

        listOf(
            "Android",
            "Kotlin"
        ).forEach { nombre ->

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = opcion == nombre,
                    onClick = {
                        opcion = nombre
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Dorado,
                        unselectedColor = Dorado,
                        disabledSelectedColor = GrisClaro,
                        disabledUnselectedColor = GrisClaro
                    )
                )

                Text(
                    text = nombre,
                    color = Blanco,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun EjemploSlider() {

    var valor by remember {
        mutableFloatStateOf(0.5f)
    }

    Column {

        TituloEjemplo("Slider")

        Slider(
            value = valor,
            onValueChange = {
                valor = it
            },
            colors = SliderDefaults.colors(
                thumbColor = Dorado,
                activeTrackColor = Dorado,
                inactiveTrackColor = Negro
            ),
            modifier = Modifier.padding(
                horizontal = 15.dp
            )
        )

        Text(
            text = "Valor: ${(valor * 100).toInt()}%",
            color = Blanco,
            fontSize = 18.sp,
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
fun EjemploSpacer() {

    Column {

        TituloEjemplo("Spacer")

        TarjetaDorada(
            texto = "Elemento superior",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(60.dp)
        )

        TarjetaDorada(
            texto = "Elemento inferior",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun EjemploSwitch() {

    var activo by remember {
        mutableStateOf(false)
    }

    Column {

        TituloEjemplo("Switch")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Switch(
                checked = activo,
                onCheckedChange = {
                    activo = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Black,
                    checkedTrackColor = Dorado,
                    checkedBorderColor = Dorado,
                    uncheckedThumbColor = Dorado,
                    uncheckedTrackColor = Negro,
                    uncheckedBorderColor = Dorado
                )
            )

            Text(
                text = if (activo) {
                    "Activado"
                } else {
                    "Desactivado"
                },
                color = Blanco,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploTopAppBar() {

    TopAppBar(
        title = {

            Text(
                text = "TopAppBar",
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Negro,
            titleContentColor = Dorado,
            navigationIconContentColor = Dorado,
            actionIconContentColor = Dorado
        )
    )
}

@Composable
fun EjemploBottomNavigation() {

    var seleccionado by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TituloEjemplo("BottomNavigation")

        Spacer(
            modifier = Modifier.weight(1f)
        )

        NavigationBar(
            containerColor = Negro,
            contentColor = Blanco
        ) {

            listOf(
                "Inicio",
                "Perfil",
                "Ajustes"
            ).forEachIndexed { index, texto ->

                NavigationBarItem(
                    selected = seleccionado == index,
                    onClick = {
                        seleccionado = index
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        selectedTextColor = Dorado,
                        indicatorColor = Dorado,
                        unselectedIconColor = Blanco,
                        unselectedTextColor = Blanco
                    ),
                    icon = {

                        Text(
                            text = "${index + 1}",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    label = {

                        Text(texto)
                    }
                )
            }
        }
    }
}

@Composable
fun EjemploDialog() {

    var mostrar by remember {
        mutableStateOf(false)
    }

    Column {

        TituloEjemplo("Dialog")

        BotonDorado(
            texto = "Abrir diálogo",
            onClick = {
                mostrar = true
            }
        )

        if (mostrar) {

            Dialog(
                onDismissRequest = {
                    mostrar = false
                }
            ) {

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF111111)
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Dorado
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Ejemplo de Dialog",
                            color = Dorado,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )

                        Text(
                            text = "Este contenido pertenece a un Dialog.",
                            color = Blanco
                        )

                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )

                        BotonDorado(
                            texto = "Cerrar",
                            onClick = {
                                mostrar = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EjemploDivider() {

    Column {

        TituloEjemplo("Divider")

        Text(
            text = "Elemento superior",
            color = Blanco,
            fontSize = 18.sp
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                vertical = 20.dp
            ),
            thickness = 2.dp,
            color = Dorado
        )

        Text(
            text = "Elemento inferior",
            color = Blanco,
            fontSize = 18.sp
        )
    }
}

@Composable
fun EjemploDropDownMenu() {

    var expandido by remember {
        mutableStateOf(false)
    }

    var opcion by remember {
        mutableStateOf("Seleccionar")
    }

    Column {

        TituloEjemplo("DropDownMenu")

        Box(
            modifier = Modifier.wrapContentSize()
        ) {

            BotonDorado(
                texto = opcion,
                onClick = {
                    expandido = true
                }
            )

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = {
                    expandido = false
                },
                containerColor = Color(0xFF111111),
                border = BorderStroke(
                    width = 1.dp,
                    color = Dorado
                )
            ) {

                listOf(
                    "Android",
                    "Kotlin",
                    "Compose"
                ).forEach { item ->

                    DropdownMenuItem(
                        text = {

                            Text(
                                text = item,
                                color = Blanco
                            )
                        },
                        onClick = {
                            opcion = item
                            expandido = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EjemploLazyVerticalGrid() {

    val datos = (1..12).toList()

    Column {

        TituloEjemplo("LazyVerticalGrid")

        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {

            items(datos) { numero ->

                    TarjetaDorada(
                        texto = "$numero",
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }


@Composable
fun EjemploNavigationRail() {

    var seleccionado by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {

        NavigationRail(
            containerColor = Negro,
            contentColor = Blanco
        ) {

            repeat(3) { index ->

                NavigationRailItem(
                    selected = seleccionado == index,
                    onClick = {
                        seleccionado = index
                    },
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        selectedTextColor = Dorado,
                        indicatorColor = Dorado,
                        unselectedIconColor = Blanco,
                        unselectedTextColor = Blanco
                    ),
                    icon = {

                        Text(
                            text = "${index + 1}",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    label = {

                        Text("Item ${index + 1}")
                    }
                )
            }
        }

        Column(
            modifier = Modifier.padding(25.dp)
        ) {

            TituloEjemplo("NavigationRail")

            Text(
                text = "Elemento seleccionado: ${seleccionado + 1}",
                color = Blanco
            )
        }
    }
}

@Composable
fun EjemploOutlinedTextField() {

    var texto by remember {
        mutableStateOf("")
    }

    Column {

        TituloEjemplo("OutlinedTextField")

        OutlinedTextField(
            value = texto,
            onValueChange = {
                texto = it
            },
            placeholder = {

                Text(
                    text = "Ingresa tu nombre",
                    color = GrisClaro
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Blanco,
                unfocusedTextColor = Blanco,
                focusedContainerColor = Negro,
                unfocusedContainerColor = Negro,
                focusedIndicatorColor = Dorado,
                unfocusedIndicatorColor = Dorado,
                cursorColor = Dorado
            )
        )
    }
}

@Composable
fun EjemploPager() {

    val estado = rememberPagerState(
        pageCount = {
            3
        }
    )

    Column {

        TituloEjemplo("Pager")

        HorizontalPager(
            state = estado,
            modifier = Modifier.fillMaxWidth()
        ) { pagina ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Negro
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Dorado
                )
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Página ${pagina + 1}",
                        color = Dorado,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun EjemploSnackbar() {

    val host = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.align(
                Alignment.Center
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TituloEjemplo("Snackbar")

            BotonDorado(
                texto = "Mostrar Snackbar",
                onClick = {

                    scope.launch {

                        host.showSnackbar(
                            message = "Mensaje enviado correctamente"
                        )
                    }
                }
            )
        }

        SnackbarHost(
            hostState = host,
            modifier = Modifier.align(
                Alignment.BottomCenter
            ),
            snackbar = { datos ->

                Snackbar(
                    snackbarData = datos,
                    containerColor = Color(0xFF111111),
                    contentColor = Blanco,
                    actionColor = Dorado,
                    dismissActionContentColor = Dorado,
                    shape = RoundedCornerShape(14.dp)
                )
            }
        )
    }
}

@Composable
fun EjemploTabRow() {

    var seleccionada by remember {
        mutableIntStateOf(0)
    }

    val tabs = listOf(
        "Inicio",
        "Cursos",
        "Perfil"
    )

    Column {

        TituloEjemplo("TabRow")

        TabRow(
            selectedTabIndex = seleccionada,
            containerColor = Negro,
            contentColor = Dorado,
            indicator = {}
        ) {

            tabs.forEachIndexed { index, texto ->

                Tab(
                    selected = seleccionada == index,
                    onClick = {
                        seleccionada = index
                    },
                    selectedContentColor = Dorado,
                    unselectedContentColor = Blanco,
                    text = {

                        Text(
                            text = texto,
                            color = if (seleccionada == index) {
                                Dorado
                            } else {
                                Blanco
                            },
                            fontWeight = if (seleccionada == index) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            }
                        )
                    }
                )
            }
        }

        TarjetaDorada(
            texto = "Pestaña seleccionada: ${tabs[seleccionada]}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun EjemploTooltip() {

    Column {

        TituloEjemplo("Tooltip")

        TarjetaDorada(
            texto = "Un Tooltip muestra información adicional sobre un elemento.",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        BotonDorado(
            texto = "Información",
            onClick = {}
        )

        Text(
            text = "Mantén presionado o interactúa con el elemento para mostrar información adicional.",
            color = Dorado,
            modifier = Modifier.padding(top = 15.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewExploradorComponentes() {

    LAB3_ExploraciónDeComponentesTheme {

        ExploradorComponentes()
    }
}