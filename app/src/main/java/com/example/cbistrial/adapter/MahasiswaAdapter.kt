package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Mahasiswa
import com.example.cbistrial.viewholder.MahasiswaViewHolder

class MahasiswaAdapter(mahasiswa: ArrayList<Mahasiswa>,context: Context) :
    RecyclerView.Adapter<MahasiswaViewHolder>() {

    private val mContext = context
    private val mMahasiswa = mahasiswa

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        return MahasiswaViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mahasiswa,parent,false))
    }

    override fun getItemCount(): Int = mMahasiswa.size

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.nama.setText(mMahasiswa.get(position).nama)
        holder.nama.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteMahasiswa(mMahasiswa.get(position).nim.toInt())
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }
}