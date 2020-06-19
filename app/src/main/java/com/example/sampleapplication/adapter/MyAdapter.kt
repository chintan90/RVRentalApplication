package com.example.sampleapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.sampleapplication.R
import com.example.sampleapplication.model.VehicleData

class MyAdapter(private val items: ArrayList<VehicleData>, private val context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.delegate_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicleData = items[position]
        val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

        holder.vehicleName.text = vehicleData.attributes.vehicleName
        Glide.with(context).load(vehicleData.attributes.vehicleImage)
            .apply(requestOptions)
            .into(holder.vehicleImage)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var vehicleName: TextView = itemView.findViewById(R.id.tvModelName)
        var vehicleImage: ImageView = itemView.findViewById(R.id.imgModel)
    }
}