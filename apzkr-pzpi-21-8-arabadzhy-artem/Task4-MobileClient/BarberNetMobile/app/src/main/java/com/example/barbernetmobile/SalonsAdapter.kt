package com.example.barbernetmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barbernetmobile.classes.Salon
/*
class SalonsAdapter(private var salons: List<Salon>) : RecyclerView.Adapter<SalonsAdapter.SalonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.salon_salon, parent, false)
        return SalonViewHolder(view)
    }

    override fun onBindViewHolder(holder: SalonViewHolder, position: Int) {
        val salon = salons[position]
        holder.bind(salon)
    }

    override fun getItemCount(): Int {
        return salons.size
    }

    fun setData(salons: List<Salon>) {
        this.salons = salons
        notifyDataSetChanged()
    }

    inner class SalonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val salonName: TextView = itemView.findViewById(R.id.salonName)
        private val salonAddress: TextView = itemView.findViewById(R.id.salonAddress)

        fun bind(salon: Salon) {
            salonName.text = salon.name
            salonAddress.text = salon.address

            itemView.setOnClickListener {
            }
        }
    }
}
*/