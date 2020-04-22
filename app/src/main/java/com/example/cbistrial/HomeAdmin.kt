package com.example.cbistrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.cbistrial.create.*
import com.example.cbistrial.list.*
import kotlinx.android.synthetic.main.activity_create_jadwal_ujian.*
import kotlinx.android.synthetic.main.activity_home_admin.*
import kotlinx.android.synthetic.main.activity_home_admin.create_jadwal_kuliah_btn
import kotlinx.android.synthetic.main.activity_home_admin.list_berita_btn
import kotlinx.android.synthetic.main.activity_home_mahasiswa.*
import kotlinx.android.synthetic.main.item_mahasiswa.*

class HomeAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)
        create_admin_btn.setOnClickListener {
            val intent = Intent(this,CreateAdmin::class.java)
            startActivity(intent)
        }
        list_admin_btn.setOnClickListener {
            val intent = Intent(this,ListAdmin::class.java)
            startActivity(intent)
        }
        create_mahasiswa_btn.setOnClickListener {
            val intent = Intent(this,CreateMahasiswa::class.java)
            startActivity(intent)
        }
        list_mahasiswa_btn.setOnClickListener {
            val intent = Intent(this,ListMahasiswa::class.java)
            startActivity(intent)
        }
        create_dosen_btn.setOnClickListener {
            val intent = Intent(this,CreateDosen::class.java)
            startActivity(intent)
        }
        list_dosen_btn.setOnClickListener {
            val intent = Intent(this,ListDosen::class.java)
            startActivity(intent)
        }
        create_berita_btn.setOnClickListener {
            val intent = Intent(this,CreateBerita::class.java)
            startActivity(intent)
        }
        list_berita_btn.setOnClickListener {
            val intent = Intent(this,ListBerita::class.java)
            startActivity(intent)
        }
        create_jadwal_ujian_btn.setOnClickListener {
            val intent = Intent(this,CreateJadwalUjian::class.java)
            startActivity(intent)
        }
        create_jadwal_kuliah_btn.setOnClickListener {
            val intent = Intent(this,CreateJadwalKuliah::class.java)
            startActivity(intent)
        }
        list_jadwal_btn.setOnClickListener {
            val intent = Intent(this,ListJadwalKuliah::class.java)
            startActivity(intent)
        }
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
