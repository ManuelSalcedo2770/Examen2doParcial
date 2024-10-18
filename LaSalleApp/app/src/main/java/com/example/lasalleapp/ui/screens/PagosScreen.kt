package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

data class Payment(
    val description: String,
    val folio: String,
    val Date: String,
    val status: String,
    val color: Color
)

val pendingPayments = listOf(
    Payment("Segundo pago de colegiatura", "CPAL00034197", "Septiembre 10, 2024", "PAGO PENDIENTE", Color.Red),
    Payment("Tercer pago de colegiatura", "CPAL00049602", "Octubre 10, 2024", "PAGO PENDIENTE", Color.Red)
)

val completedPayments = listOf(
    Payment("Cuarto pago de colegiatura", "CPAL00008749", "Mayo 10, 2024", "PAGADO", Color.Green),
    Payment("Quinto pago de colegiatura", "CPAL00008750", "Junio 07, 2024", "PAGADO", Color.Green),
    Payment("Pago de reinscripción", "CPAL00012122", "Julio 15, 2024", "PAGADO", Color.Green)
)

@Composable
fun PaymentsScreen(navController: NavController) {
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
                        text = "Pagos",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        items(pendingPayments.size) { index ->
            PaymentCard(payment = pendingPayments[index])
        }

        items(completedPayments.size) { index ->
            PaymentCard(payment = completedPayments[index])
        }
    }
}


@Composable
fun PaymentCard(payment: Payment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (payment.status == "PAGADO") {
                Color.LightGray
            } else {
                Color(0xFFFFE66D)
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = payment.description, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Folio: ${payment.folio}", fontSize = 14.sp)
                Text(text = "Vencimiento: ${payment.Date}", fontSize = 14.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0x37224DB4))
                    .padding(4.dp)
                    .weight(1f)
                    .height(110.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Icono según el estado del pago
                Icon(
                    imageVector = if (payment.status == "PAGADO") Icons.Filled.CheckCircle else Icons.Filled.Warning,
                    contentDescription = if (payment.status == "PAGADO") "Pagado" else "Pendiente",
                    tint = payment.color // aquí se usa el color del pago para el icono
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = payment.status,
                    color = payment.color,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun PaymentsScreenPreview() {
    val navController = rememberNavController()
    LaSalleAppTheme {
        PaymentsScreen(navController)
    }
}