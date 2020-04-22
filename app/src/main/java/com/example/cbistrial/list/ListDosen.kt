package com.example.cbistrial.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.adapter.DosenAdapter

class ListDosen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_dosen)
        init()
    }

    private fun init() {
        val db = DatabaseHelper(this)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val adapter = DosenAdapter(db.getDosen(),this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}
