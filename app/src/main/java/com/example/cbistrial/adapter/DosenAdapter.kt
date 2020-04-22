package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Dosen
import com.example.cbistrial.viewholder.DosenViewHolder

class DosenAdapter (dosen: ArrayList<Dosen>,context: Context) :
    RecyclerView.Adapter<DosenViewHolder>() {

    private val mContext = context
    private val mDosen = dosen
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosenViewHolder {
        return DosenViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_dosen,parent,false))
    }

    override fun getItemCount(): Int = mDosen.size

    override fun onBindViewHolder(holder: DosenViewHolder, position: Int) {
        holder.nama.setText(mDosen.get(position).nama)
        holder.nama.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteDosen(mDosen.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }

}