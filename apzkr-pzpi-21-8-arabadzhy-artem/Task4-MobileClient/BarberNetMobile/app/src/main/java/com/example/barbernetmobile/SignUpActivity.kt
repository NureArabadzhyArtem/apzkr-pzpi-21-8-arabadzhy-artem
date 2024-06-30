package com.example.barbernetmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbernetmobile.classes.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        apiService = RetrofitClient.getClient().create(ApiService::class.java)

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSignUp = findViewById(R.id.buttonSignUp)

        buttonSignUp.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                // Виклик функції для реєстрації нового користувача
                registerUser(name, email)
            } else {
                showToast("Please enter name and email")
            }
        }
    }

    private fun registerUser(name: String, email: String) {
        val user = User(email, name)
        apiService.createUser(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    showToast("User registered successfully!")
                    // Перехід до сторінки авторизації після успішної реєстрації
                    navigateToLogin()
                } else {
                    showToast("Failed to register user")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                showToast("Network error: ${t.message}")
            }
        })
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Закрити поточну активність SignUpActivity
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
