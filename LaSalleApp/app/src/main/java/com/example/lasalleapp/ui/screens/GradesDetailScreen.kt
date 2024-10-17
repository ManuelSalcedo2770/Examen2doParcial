package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun SubjectDetailsScreen(subjectName: String, innerPadding: PaddingValues) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Text(text = subjectName, style = MaterialTheme.typography.headlineMedium)
    }, body = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Calificaciones de los tres parciales:", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Parcial 1: 8.5", style = MaterialTheme.typography.bodyLarge)
            Text("Parcial 2: 9.0", style = MaterialTheme.typography.bodyLarge)
            Text("Parcial 3: 9.2", style = MaterialTheme.typography.bodyLarge)
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubjectDetailsScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        SubjectDetailsScreen(subjectName = "POO", innerPadding = PaddingValues(0.dp))
    }
}
