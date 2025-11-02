package com.example.activity4_userinput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    // Variabel untuk mengingat nilai input
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    // Daftar pilihan untuk RadioButton
    val listJk = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Lajang", "Menikah", "Janda", "Duda")

    // Column utama yang mengatur semua elemen form
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp), // Beri padding di sekeliling Column
        verticalArrangement = Arrangement.spacedBy(16.dp) // Jarak vertikal antar komponen
    ) {

        // --- NAMA LENGKAP ---
        FormComponent(
            title = "NAMA LENGKAP",
            content = {
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large, // Bentuk lebih rounded
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Isian nama lengkap") },
                    onValueChange = { textNama = it }
                )
            }
        )

        // --- JENIS KELAMIN ---
        FormComponent(
            title = "JENIS KELAMIN",
            content = {
                Column {
                    listJk.forEach { item ->
                        SelectableRow(
                            text = item,
                            selected = textJK == item,
                            onSelected = { textJK = it }
                        )
                    }
                }
            }
        )

        // --- STATUS PERKAWINAN --- (Bagian baru)
        FormComponent(
            title = "STATUS PERKAWINAN",
            content = {
                Column {
                    listStatus.forEach { item ->
                        SelectableRow(
                            text = item,
                            selected = textStatus == item,
                            onSelected = { textStatus = it }
                        )
                    }
                }
            }
        )

        // --- ALAMAT ---
        FormComponent(
            title = "ALAMAT",
            content = {
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Alamat") },
                    onValueChange = { textAlamat = it }
                )
            }
        )

        // Beri jarak sebelum tombol
        Spacer(modifier = Modifier.height(16.dp))

        // --- TOMBOL SUBMIT ---
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF673AB7) // Warna ungu
            ),
            onClick = {
                // Logika ketika tombol di klik bisa ditambahkan di sini
                // Contoh: Log.d("FormData", "Nama: $textNama, JK: $textJK, Status: $textStatus, Alamat: $textAlamat")
            }
        ) {
            Text(stringResource(R.string.submit), color = Color.White)
        }

        // ElevatedCard dan Divider dari kode lama telah dihapus karena tidak ada di desain baru.
    }
}

/**
 * Composable bantuan untuk membuat baris yang bisa dipilih (RadioButton + Text).
 * Ini membantu agar kode tidak berulang.
 */
@Composable
fun SelectableRow(
    text: String,
    selected: Boolean,
    onSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = { onSelected(text) }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = { onSelected(text) }
        )
        // Beri sedikit jarak antara radio button dan teks
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

/**
 * Composable bantuan untuk membuat grup form (Judul + Konten).
 * Ini membuat layout lebih konsisten.
 */
@Composable
fun FormComponent(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp) // Jarak antara judul dan konten
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        content()
    }
}
