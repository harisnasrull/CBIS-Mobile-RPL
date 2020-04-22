package com.example.cbistrial.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.HomeAdmin
import com.example.cbistrial.R
import com.example.cbistrial.table.Mahasiswa
import kotlinx.android.synthetic.main.activity_create_mahasiswa.*

class CreateMahasiswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_mahasiswa)
        btn_create_mahasiswa.setOnClickListener {
            insertMahasiswa()
            val intent = Intent(this,HomeAdmin::class.java)
            startActivity(intent)
        }
    }
    private fun insertMahasiswa() {
        val db = DatabaseHelper(this)
        create_status_mahasiswa.setText("0")
        val mhs = Mahasiswa(
            create_nim_mahasiswa.text.toString(),
            create_nama_mahasiswa.text.toString(),
            create_password_mahasiswa.text.toString(),
            create_status_mahasiswa.text.toString()
        )
        db.insertMahasiswa(mhs)
    }
}
