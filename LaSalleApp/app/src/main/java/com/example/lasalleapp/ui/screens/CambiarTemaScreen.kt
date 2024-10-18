package com.example.lasalleapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.* // Se importa remember y mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun CambiarTemaScreen(subjectName: String, innerPadding: PaddingValues, navController: NavController) {
    var isDarkTheme by remember { mutableStateOf(true) } // Estado para controlar el tema

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item { // Header azul oscuro
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF002E5D))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(70.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = subjectName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        item { // card con botón para cambiar el tema
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Tema oscuro", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.weight(1f)) // se hace el Switch a la derecha
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { isDarkTheme = it }, // se actualiza el estado del tema
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.DarkGray, // Color del thumb cuando está activado
                            checkedTrackColor = Color.LightGray, // Color del track cuando está activado
                            uncheckedThumbColor = Color.LightGray, // Color del thumb cuando está desactivado
                            uncheckedTrackColor = Color.DarkGray // Color del track cuando está desactivado
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChangeThemeScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        CambiarTemaScreen("Cambiar Tema", innerPadding = PaddingValues(0.dp), navController = navController)
    }
}