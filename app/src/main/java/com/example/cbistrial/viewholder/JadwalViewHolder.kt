package com.example.cbistrial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_jadwal.view.*

class JadwalViewHolder (itemview: View) : RecyclerView.ViewHolder(itemview){
    val hari = itemview.tv_hari
    val nama_matkul = itemview.tv_nama_matkul
    val sesi = itemview.tv_sesi
    val btn_list_jadwal = itemview.item_jadwal
}