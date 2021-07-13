package com.moringa.android.g4saccesscsystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moringa.android.g4saccesscsystem.databinding.PhoneLayoutBinding
import com.moringa.android.g4saccesscsystem.model.Phonedetails

class PhonedetailsAdapter (val context: Context, val items: ArrayList<Phonedetails>):RecyclerView.Adapter<PhonedetailsAdapter.PhoneViewHolder> () {
    class PhoneViewHolder(val binding:PhoneLayoutBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(PhoneLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.binding.apply {
            val list = items[position]
            tvName.text=list.name
            tvSimon.text=list.title
            tvDate.text=list.date
            tvOffice.text=list.office
            tvEclectics.text=list.destination
            tvTime.text=list.time
            Ivcall.setImageResource(list.image)
        }
    }

    override fun getItemCount() = items.size

}