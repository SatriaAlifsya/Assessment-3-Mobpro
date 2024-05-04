package org.d3if0025.mobpro01.model

data class Mahasiswa(
    val id: Long,
    val nama: String,
    val nim: String,
    val kelas: String,
    var selectedOption: String = ""
)