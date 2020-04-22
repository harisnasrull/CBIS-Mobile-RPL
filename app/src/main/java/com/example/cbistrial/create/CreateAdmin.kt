package com.example.cbistrial.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.HomeAdmin
import com.example.cbistrial.R
import com.example.cbistrial.table.Admin
import kotlinx.android.synthetic.main.activity_create_admin.*

class CreateAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_admin)
        btn_create_admin.setOnClickListener {
            insertAdmin()
            val intent = Intent(this,HomeAdmin::class.java)
            startActivity(intent)
        }
    }
    private fun insertAdmin() {
        val db = DatabaseHelper(this)
        create_status_admin.setText("0")
        val admin = Admin(
            create_code_admin.text.toString(),
            create_password_admin.text.toString(),
            create_status_admin.text.toString()
        )
        db.insertAdmin(admin)
    }
}
