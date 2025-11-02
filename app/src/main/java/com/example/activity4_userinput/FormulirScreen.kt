package com.example.activity4_userinput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TugasForm() {
    val headerColor : Color = Color(0xFF5B2EFF)

    // STATE UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("Laki-laki") }
    var status by remember { mutableStateOf("Janda") }

    Box(modifier = Modifier.fillMaxSize()) {
        // Header ungu
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(105.dp)
                .background(headerColor)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(50.dp))
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(Modifier.height(20.dp))

            //Card
            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .shadow(elevation = 6.dp, shape = RoundedCornerShape(24.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    SectionLabel("NAMA LENGKAP")
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        placeholder = { Text("Isian nama lengkap") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp)
                    )

                    SectionLabel("JENIS KELAMIN")
                    RadioGroup(
                        options = listOf("Laki-laki", "Perempuan"),
                        selected = jenisKelamin,
                        onSelect = { jenisKelamin = it }
                    )
                    Spacer(Modifier.height(8.dp))

                    SectionLabel("STATUS PERKAWINAN")
                    RadioGroup(
                        options = listOf("Janda", "Lajang", "Duda"),
                        selected = status,
                        onSelect = { status = it }
                    )
                    Spacer(Modifier.height(8.dp))

                    SectionLabel("ALAMAT")
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        placeholder = { Text("Alamat") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )

                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(28.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5B2EFF),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Submit", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge.copy(
            color = Color(0xFF757575),
            letterSpacing = 0.5.sp
        )
    )
}
