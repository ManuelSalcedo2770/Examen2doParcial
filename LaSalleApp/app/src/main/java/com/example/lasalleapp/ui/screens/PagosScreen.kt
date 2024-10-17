package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.ui.components.ScreenTemplate
import com.example.lasalleapp.ui.theme.LaSalleAppTheme

@Composable
fun PaymentsScreen(innerPadding: PaddingValues, navController: NavController) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Text(text = "Historial de Pagos", style = MaterialTheme.typography.headlineMedium)
    }, body = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val payments = listOf(
                "Enero" to true,
                "Febrero" to true,
                "Marzo" to false,
                "Abril" to false,
                "Mayo" to true
            )

            payments.forEach { (month, isPaid) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = month, style = MaterialTheme.typography.bodyLarge)
                    Icon(
                        imageVector = if (isPaid) Icons.Default.Check else Icons.Default.Warning,
                        contentDescription = if (isPaid) "Pagado" else "Pendiente",
                        tint = if (isPaid) Color.Green else Color.Red
                    )
                }
            }
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentsScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        PaymentsScreen(innerPadding = PaddingValues(0.dp), navController = navController)
    }
}
