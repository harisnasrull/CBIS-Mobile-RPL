package com.example.cbistrial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_jadwal_ujian.view.*

class JadwalUjianViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val kode = itemView.tv_code_jadwal
    val tanggal = itemView.tv_tanggal_ujian
    val itemUjian = itemView.item_jadwal_ujian
}