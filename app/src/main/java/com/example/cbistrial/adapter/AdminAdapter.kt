package com.example.cbistrial.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cbistrial.DatabaseHelper
import com.example.cbistrial.R
import com.example.cbistrial.table.Admin
import com.example.cbistrial.viewholder.AdminViewHolder


class AdminAdapter(admin : ArrayList<Admin>,context: Context) :
    RecyclerView.Adapter<AdminViewHolder>() {

    private val mContext = context
    private val mAdmin = admin
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        return AdminViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_admin,parent,false))
    }

    override fun getItemCount(): Int = mAdmin.size

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        holder.nama.setText(mAdmin.get(position).code)
        holder.nama.setOnClickListener {
            val db = DatabaseHelper(mContext)
            db.deleteAdmin(mAdmin.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Success Delete News", Toast.LENGTH_SHORT).show()
        }
    }
}