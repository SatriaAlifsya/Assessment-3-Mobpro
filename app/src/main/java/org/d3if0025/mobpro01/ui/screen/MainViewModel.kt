package org.d3if0025.mobpro01.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if0025.mobpro01.model.Mahasiswa

class MainViewModel : ViewModel() {
    val data = getDataDummy()

    private fun getDataDummy(): List<Mahasiswa> {
        val data = mutableListOf<Mahasiswa>()
        data.add(Mahasiswa(1, "Tangguh Satria", "6706220025", "D3IF-46-03"))
        data.add(Mahasiswa(2, "Davin Wahyu Wardana", "6706220021", "D3IF-46-02"))
        data.add(Mahasiswa(3, "Dimas Dwi Kurniawan", "6706223302", "D3IF-46-02"))
        data.add(Mahasiswa(4, "Anugrah Panji Pradipa", "6706225812", "D3IF-46-04"))
        data.add(Mahasiswa(5, "Muhammad Hudansah", "6706220103", "D3IF-46-05"))
        data.add(Mahasiswa(6, "Lestari", "6706223567", "D3IF-46-01"))
        data.add(Mahasiswa(7, "Ananda Hawa", "6706225612", "D3IF-46-02"))
        data.add(Mahasiswa(8, "Wandi Ridwansah", "6706227342", "D3IF-46-03"))
        data.add(Mahasiswa(9, "Ahmad Dani", "6706225125", "D3IF-46-03"))
        return data
    }
}