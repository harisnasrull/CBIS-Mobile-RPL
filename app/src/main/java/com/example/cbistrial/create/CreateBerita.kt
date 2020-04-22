package com.example.cbistrial.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.HomeAdmin
import com.example.cbistrial.R
import com.example.cbistrial.table.Berita
import kotlinx.android.synthetic.main.activity_create_berita.*

class CreateBerita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_berita)
        btn_create_berita.setOnClickListener {
            insertBerita()
            val intent = Intent(this,HomeAdmin::class.java)
            startActivity(intent)
        }
    }

    private fun insertBerita() {
        val db = DatabaseHelper(this)
        val berita = Berita(
            create_title_berita.text.toString(),
            create_isi_berita.text.toString(),
            create_date_berita.text.toString()
        )
        db.insertBerita(berita)
    }
}
