package com.example.cbistrial.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Jadwal
import kotlinx.android.synthetic.main.activity_create_jadwal.*

class CreateJadwal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_jadwal)
        btn_create_jadwal.setOnClickListener {
            insertJadwal()
        }
    }

    private fun insertJadwal() {
        val db = DatabaseHelper(this)
        val jadwal = Jadwal(
            create_code_jadwal.text.toString(),
            create_code_matkul_jadwal.text.toString(),
            create_code_dosen_jadwal.text.toString(),
            create_hari.text.toString(),
            create_sesi.text.toString()
        )
        db.insertJadwal(jadwal)
    }
}
