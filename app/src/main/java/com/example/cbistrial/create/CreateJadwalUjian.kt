package com.example.cbistrial.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.JadwalUjian
import kotlinx.android.synthetic.main.activity_create_jadwal_ujian.*

class CreateJadwalUjian : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_jadwal_ujian)
        btn_create_jadwal_ujian.setOnClickListener {
            insertJadwalUjian()
        }
    }

    private fun insertJadwalUjian() {
        val db = DatabaseHelper(this)
        val jadwalUjian = JadwalUjian(
            create_code_jadwal_ujian.text.toString(),
            create_tanggal_ujian.text.toString()
        )
        db.insertUjian(jadwalUjian)
    }
}
