package com.example.cbistrial.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.HomeAdmin
import com.example.cbistrial.R
import com.example.cbistrial.adapter.DosenAdapter
import com.example.cbistrial.table.Dosen
import kotlinx.android.synthetic.main.activity_create_dosen.*

class CreateDosen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_dosen)
        btn_create_dosen.setOnClickListener {
            insertDosen()
            val intent = Intent(this,HomeAdmin::class.java)
            startActivity(intent)
        }
    }
    private fun insertDosen() {
        val db = DatabaseHelper(this)
        create_status_dosen.setText("0")
        val dosen = Dosen(
            create_code_dosen.text.toString(),
            create_nama_dosen.text.toString(),
            create_password_dosen.text.toString(),
            create_status_dosen.text.toString()
        )
        db.insertDosen(dosen)
    }
}
