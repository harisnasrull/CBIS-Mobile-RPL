package com.example.cbistrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val db = DatabaseHelper(this)
//        val cekmhs = db.cekMahasiswa(login_nim.text.toString(),login_password.text.toString())
//        val cekdosen = db.cekDosen(login_nim.text.toString(),login_password.text.toString())
//        val cekadmin = db.cekAdmin(login_nim.text.toString(),login_password.text.toString())
        btn_login.setOnClickListener {
            if (login_nim.text.toString().equals("admin")&&login_password.text.toString().equals("admin")){
                val intent = Intent(this,HomeAdmin::class.java)
                startActivity(intent)
            }
            else if (login_nim.text.toString().equals("123180055")&&login_password.text.toString().equals("hanas")){
                val intent = Intent(this,HomeMahasiswa::class.java)
                startActivity(intent)
            }
            else if (login_nim.text.toString().equals("SMN01")&&login_password.text.toString().equals("rpljaya")){
                val intent = Intent(this,HomeDosen::class.java)
                startActivity(intent)
            }
//            if (cekmhs){
//                val intent = Intent(this,HomeMahasiswa::class.java)
//                startActivity(intent)
//            }
//            else {
//                if (cekdosen) {
//                    val intent = Intent(this,HomeAdmin::class.java)
//                    startActivity(intent)
//                }
//                else {
//                    if (cekadmin) {
//                        val intent = Intent(this,HomeDosen::class.java)
//                        startActivity(intent)
//                    }
//                }
//            }

        }
    }
}
