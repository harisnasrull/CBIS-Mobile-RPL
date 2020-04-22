package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Jadwal
import com.example.cbistrial.viewholder.JadwalViewHolder

class JadwalAdapter (jadwal: ArrayList<Jadwal>,context: Context) :
    RecyclerView.Adapter<JadwalViewHolder>() {

    private val mContext = context
    private val mJadwal = jadwal
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        return JadwalViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_jadwal,parent,false))
    }

    override fun getItemCount(): Int = mJadwal.size

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        holder.hari.setText(mJadwal.get(position).hari)
        holder.nama_matkul.setText(mJadwal.get(position).kode_matkul)
        holder.sesi.setText(mJadwal.get(position).sesi)
        holder.btn_list_jadwal.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteJadwal(mJadwal.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }
}