package com.example.week.Timetable.Thursday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week.R

class MyAdapterThursdayTimetable(var userList: ArrayList<DatalistThursdayTimetable>): RecyclerView.Adapter<MyAdapterThursdayTimetable.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun OnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView)
    {
        val tname: TextView = itemView.findViewById(R.id.NameInItemTimeTable)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_timetable, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tname.text = currentItem.name
    }

}