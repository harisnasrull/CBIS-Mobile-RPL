package com.example.cbistrial.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.R
import com.example.cbistrial.table.Matkul
import com.example.cbistrial.viewholder.MatkulViewHolder

class MatkulAdapter (matkul: ArrayList<Matkul>,context: Context) :
RecyclerView.Adapter<MatkulViewHolder>() {

    private val mContext = context
    private val mMatkul = matkul
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatkulViewHolder {
        return MatkulViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_matkul,parent,false))
    }

    override fun getItemCount(): Int = mMatkul.size

    override fun onBindViewHolder(holder: MatkulViewHolder, position: Int) {
        holder.nama.setText(mMatkul.get(position).nama)
    }
}