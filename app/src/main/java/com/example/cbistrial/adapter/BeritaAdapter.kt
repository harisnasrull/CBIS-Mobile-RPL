package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Berita
import com.example.cbistrial.viewholder.BeritaViewHolder

class BeritaAdapter (berita: ArrayList<Berita>,context: Context) :
    RecyclerView.Adapter<BeritaViewHolder>() {

    private val mContext = context
    private val mBerita = berita
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        return BeritaViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_berita,parent,false))
    }

    override fun getItemCount(): Int =mBerita.size

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.judul.setText(mBerita.get(position).judul)
        holder.isi.setText(mBerita.get(position).isi)
        holder.date.setText(mBerita.get(position).tanggal)
        holder.btn_list_berita.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteBerita(mBerita.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }
}