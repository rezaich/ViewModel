package com.zaich.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zaich.viewmodel.databinding.WeatherItemsBinding

class WeatherAdapter :RecyclerView.Adapter<WeatherAdapter.WeatherHolder>(){
    private val mData = ArrayList<WeatherItems>()

    fun setData(items: ArrayList<WeatherItems>){
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.weather_items,parent,false)
        return WeatherHolder(mView)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class WeatherHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = WeatherItemsBinding.bind(itemView)
        fun bind(weatherItems: WeatherItems){
            binding.textCity.text = weatherItems.name
            binding.textTemp.text = weatherItems.temperature
            binding.textDesc.text = weatherItems.description
        }
    }
}