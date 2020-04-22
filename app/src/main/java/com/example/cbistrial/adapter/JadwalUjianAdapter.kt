package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.JadwalUjian
import com.example.cbistrial.viewholder.JadwalUjianViewHolder
import com.example.cbistrial.viewholder.JadwalViewHolder


class JadwalUjianAdapter (jadwalUjian: ArrayList<JadwalUjian>,context: Context) :
    RecyclerView.Adapter<JadwalUjianViewHolder>() {

    private val mContext = context
    private val mJadwalUjian = jadwalUjian
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalUjianViewHolder {
        return JadwalUjianViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_jadwal_ujian,parent,false))
    }

    override fun getItemCount(): Int = mJadwalUjian.size

    override fun onBindViewHolder(holder: JadwalUjianViewHolder, position: Int) {
        holder.kode.setText(mJadwalUjian.get(position).kode_jadwal)
        holder.tanggal.setText(mJadwalUjian.get(position).tanggal)
        holder.itemUjian.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteJadwalUjian(mJadwalUjian.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }

}