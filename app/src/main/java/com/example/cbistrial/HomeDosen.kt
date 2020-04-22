package com.example.cbistrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.cbistrial.create.CreateMatkul
import com.example.cbistrial.create.CreateNilai
import com.example.cbistrial.list.ListMatkul
import com.example.cbistrial.list.ListNilai
import kotlinx.android.synthetic.main.activity_home_dosen.*

class HomeDosen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_dosen)

        create_mata_kuliah_btn.setOnClickListener {
            val intent = Intent(this,CreateMatkul::class.java)
            startActivity(intent)
        }
        list_mata_kuliah_btn.setOnClickListener {
            val intent = Intent(this,ListMatkul::class.java)
            startActivity(intent)
        }
        create_nilai_btn.setOnClickListener {
            val intent = Intent(this,CreateNilai::class.java)
            startActivity(intent)
        }
        list_nilai_dosen_btn.setOnClickListener {
            val intent = Intent(this,ListNilai::class.java)
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
