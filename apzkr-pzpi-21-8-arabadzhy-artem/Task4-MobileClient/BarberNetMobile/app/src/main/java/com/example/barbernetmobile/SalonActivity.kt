package com.example.barbernetmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barbernetmobile.classes.Salon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*
class SalonsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SalonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salons)

        recyclerView = findViewById(R.id.recyclerViewSalons)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SalonsAdapter(emptyList()) // Початково пустий список
        recyclerView.adapter = adapter

        // Отримати список салонів з сервера
        getSalons()
    }

    private fun getSalons() {
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)
        val call = apiService.getSalons()

        call.enqueue(object : Callback<List<Salon>> {
            override fun onResponse(call: Call<List<Salon>>, response: Response<List<Salon>>) {
                if (response.isSuccessful) {
                    val salons = response.body()
                    if (salons != null) {
                        adapter.setData(salons)
                    } else {
                        Log.d("SalonsActivity", "Отримано порожній список салонів")
                    }
                } else {
                    Log.e("SalonsActivity", "Не вдалося отримати список салонів: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Salon>>, t: Throwable) {
                Log.e("SalonsActivity", "Помилка при отриманні списку салонів: ${t.message}")
                Toast.makeText(this@SalonsActivity, "Помилка при отриманні списку салонів", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
*/