package com.example.barbernetmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barbernetmobile.classes.Appointment

class AppointmentsAdapter(private var appointments: List<Appointment>) :
    RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder>() {
    fun setData(appointments: List<Appointment>) {
        this.appointments = appointments
        notifyDataSetChanged()
    }

    inner class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appointmentNumber: TextView = itemView.findViewById(R.id.appointmentNumber)
        val appointmentDate: TextView = itemView.findViewById(R.id.appointmentDate)
        val appointmentService: TextView = itemView.findViewById(R.id.appointmentService)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.appointment_item, parent, false)
        return AppointmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appointments[position]
        holder.appointmentNumber.text = "Appointment ${appointment.id}"
        holder.appointmentDate.text = appointment.date
        holder.appointmentService.text = appointment.service
        holder.buttonDelete.setOnClickListener {
            // Логіка видалення
            // Тут можна реалізувати видалення запису
        }
    }


    override fun getItemCount(): Int {
        return appointments.size
    }
}
