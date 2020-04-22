package com.example.cbistrial.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.HomeDosen
import com.example.cbistrial.R
import com.example.cbistrial.table.Matkul
import kotlinx.android.synthetic.main.activity_create_matkul.*

class CreateMatkul : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_matkul)
        btn_create_matkul.setOnClickListener {
            insertMatkul()
            val intent = Intent(this,HomeDosen::class.java)
            startActivity(intent)
        }
    }

    private fun insertMatkul() {
        val db = DatabaseHelper(this)
        val matkul = Matkul(
            create_code_matkul.text.toString(),
            create_nama_matkul.text.toString()
        )
        db.insertMataKuliah(matkul)
    }
}
