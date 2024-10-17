package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun SettingsScreen(innerPadding: PaddingValues, navController: NavController) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Text(text = "Configuración", style = MaterialTheme.typography.headlineMedium)
    }, body = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Información del alumno

            Text("José Manuel Salcedo Méndez", style = MaterialTheme.typography.bodyLarge)
            Text("Fecha de nacimiento: 21/10/2002", style = MaterialTheme.typography.bodyLarge)
            Text("Correo: jsm77250@lasalle.edu.mx", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(20.dp))

            // Opciones de navegación
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("change_password") },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Cambiar contraseña",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("change_theme") },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Cambiar tema de la aplicación",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        SettingsScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}
