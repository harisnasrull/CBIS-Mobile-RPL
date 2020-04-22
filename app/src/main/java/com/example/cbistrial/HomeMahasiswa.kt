package com.example.cbistrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.cbistrial.create.CreateJadwalKuliah
import com.example.cbistrial.list.ListBerita
import com.example.cbistrial.list.ListJadwalKuliah
import com.example.cbistrial.table.JadwalKuliah
import kotlinx.android.synthetic.main.activity_create_jadwal_kuliah.*
import kotlinx.android.synthetic.main.activity_home_mahasiswa.*

class HomeMahasiswa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_mahasiswa)
        btn_create_jadwal_kuliah.setOnClickListener {
            insertJadwalKuliah()
            val intent = Intent(this,CreateJadwalKuliah::class.java)
            startActivity(intent)
        }
        list_jadwal_kuliah_btn.setOnClickListener {
            val intent = Intent(this,ListJadwalKuliah::class.java)
            startActivity(intent)
        }
        list_berita_btn.setOnClickListener {
            val intent = Intent(this,ListBerita::class.java)
            startActivity(intent)
        }
    }
    private fun insertJadwalKuliah() {
        val db = DatabaseHelper(this)
        val jadwalKuliah = JadwalKuliah(
            create_code_jadwal_kuliah.text.toString(),
            create_nim_jadwal.text.toString())
        db.insertJadwalKuliah(jadwalKuliah)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.logout -> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
