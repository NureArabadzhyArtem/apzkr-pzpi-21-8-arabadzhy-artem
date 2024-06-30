package com.example.barbernetmobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var buttonSalons: Button
    private lateinit var buttonAppointments: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAppointments = findViewById(R.id.buttonAppointments)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)

        // Перевіряємо статус авторизації перед натисканням кнопок
        if (!isLoggedIn()) {
            disableButtons() // Вимикаємо кнопки, якщо користувач не авторизований
        }
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonAppointments.setOnClickListener {
            // Логіка переходу до сторінки зі списком записів на послуги
            val intent = Intent(this, AppointmentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isLoggedIn(): Boolean {
        // Перевіряємо значення статусу авторизації
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun disableButtons() {
        // Вимикаємо кнопки для неавторизованого користувача
        buttonSalons.isEnabled = false
        buttonAppointments.isEnabled = false
        showToast("Please log in to access this feature")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
