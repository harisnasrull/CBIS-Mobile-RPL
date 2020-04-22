package com.example.cbistrial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_berita.view.*

class BeritaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val judul = itemView.list_title_berita
    val isi = itemView.list_body_berita
    val date = itemView.list_date_berita
    val btn_list_berita = itemView.btn_list_berita
}