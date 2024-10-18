package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
                        text = "Calificaciones",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        item { // Información del alumno
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(), // Asegúrate de que el Row ocupe todo el ancho
                horizontalArrangement = Arrangement.SpaceBetween // Coloca los elementos en los extremos
            ) {
                Column { // Columna para la información del alumno
                    Text("José Manuel Salcedo Méndez", style = MaterialTheme.typography.bodyMedium)
                    Text("Carrera: Ingeniería en Sistemas", style = MaterialTheme.typography.bodyMedium)
                    Text("Semestre: 5", style = MaterialTheme.typography.bodyMedium)
                    Text("Promedio acumulado: 9.6", style = MaterialTheme.typography.bodyMedium)
                }
                Image(
                    painter = painterResource(id = R.drawable.alumno),
                    contentDescription = "Imagen del alumno",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }

        item { // Espacio entre la información del alumno y la lista de materias
            Spacer(modifier = Modifier.height(20.dp))
        }

        // Lista de materias con su promedio
        val subjects = listOf(
            "Programación en Android" to 9.2,
            "POO" to 8.7,
            "Servidores" to 9.5,
            "Base de Datos" to 8.7,
            "Redes de área local" to 8.7,
            "Aplicaciones empresariales" to 8.7,

            )

        items(subjects.size) { index -> // Lista de materias
            val (subject, average) = subjects[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("subject_details/$subject") },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "$subject: Promedio $average",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GradesScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        GradesScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}