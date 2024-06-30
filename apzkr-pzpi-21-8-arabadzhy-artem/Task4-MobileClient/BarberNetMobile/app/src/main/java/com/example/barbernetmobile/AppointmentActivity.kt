package com.example.barbernetmobile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barbernetmobile.classes.Appointment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppointmentActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        recyclerView = findViewById(R.id.recyclerViewAppointments)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AppointmentsAdapter(emptyList()) // Початково пустий список
        recyclerView.adapter = adapter

        // Отримати список записів з сервера
        getAppointments()
    }

    private fun deleteAppointment(appointmentId: String) {
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)
        val call = apiService.deleteAppointment(appointmentId)

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Видалення успішне
                    Toast.makeText(this@AppointmentActivity, "Запис успішно видалено", Toast.LENGTH_SHORT).show()
                    // Оновлення списку після видалення
                    getAppointments()
                } else {
                    Log.e("AppointmentActivity", "Не вдалося видалити запис: ${response.code()}")
                    Toast.makeText(this@AppointmentActivity, "Не вдалося видалити запис", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("AppointmentActivity", "Помилка при видаленні запису: ${t.message}")
                Toast.makeText(this@AppointmentActivity, "Помилка при видаленні запису", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getAppointments() {
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)
        val call = apiService.getAppointments("appointments") // "appointments" - параметр, якщо потрібно

        call.enqueue(object : Callback<List<Appointment>> {
            override fun onResponse(call: Call<List<Appointment>>, response: Response<List<Appointment>>) {
                if (response.isSuccessful) {
                    val appointments = response.body()
                    if (appointments != null) {
                        adapter.setData(appointments)
                    } else {
                        Log.d("AppointmentActivity", "Отримано порожній список записів")
                    }
                } else {
                    Log.e("AppointmentActivity", "Не вдалося отримати список записів: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Appointment>>, t: Throwable) {
                Log.e("AppointmentActivity", "Помилка при отриманні списку записів: ${t.message}")
                Toast.makeText(this@AppointmentActivity, "Помилка при отриманні списку записів", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
