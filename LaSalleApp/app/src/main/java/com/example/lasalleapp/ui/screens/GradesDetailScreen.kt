package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun SubjectDetailsScreen(subjectName: String, innerPadding: PaddingValues) {
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

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Calificaciones de los tres parciales:", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(8.dp))

                    // Tabla de calificaciones
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("Parcial", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                        Text("Calificación", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    }
                    Divider() // divisor entre el encabezado y las filas

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("1", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                        Text("9.5", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    }
                    Divider()
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("2", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                        Text("9.0", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    }
                    Divider()
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("3", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                        Text("9.2", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubjectDetailsScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        SubjectDetailsScreen(subjectName = "POO", innerPadding = PaddingValues(0.dp))
    }
}
