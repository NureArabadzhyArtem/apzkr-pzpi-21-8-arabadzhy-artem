package com.example.barbernetmobile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.barbernetmobile.classes.Services
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*
class ServicesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        recyclerView = findViewById(R.id.recyclerViewServices)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ServicesAdapter(emptyList()) // Початково пустий список
        recyclerView.adapter = adapter

        // Отримати список сервісів з сервера
        getServices()
    }

    private fun getServices() {
        val apiService = RetrofitClient.getClient().create(ApiService::class.java)
        val call = apiService.getServices()

        call.enqueue(object : Callback<List<Services>> {
            override fun onResponse(call: Call<List<s>>, response: Response<List<Services>>) {
                if (response.isSuccessful) {
                    val services = response.body()
                    if (services != null) {
                        adapter.setData(services)
                    } else {
                        Log.d("ServicesActivity", "Отримано порожній список сервісів")
                    }
                } else {
                    Log.e("ServicesActivity", "Не вдалося отримати список сервісів: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Services>>, t: Throwable) {
                Log.e("ServicesActivity", "Помилка при отриманні списку сервісів: ${t.message}")
                Toast.makeText(this@ServicesActivity, "Помилка при отриманні списку сервісів", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
*/