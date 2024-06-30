package com.example.barbernetmobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.barbernetmobile.classes.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonSignUp: Button
    private lateinit var sharedPreferences: SharedPreferences
    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Закрити поточну активність LoginActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiService = RetrofitClient.getClient().create(ApiService::class.java)

        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonSignUp = findViewById(R.id.buttonSignUp)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)

        buttonSubmit.setOnClickListener {
            val email = editTextEmail.text.toString().trim()

            if (email.isNotEmpty()) {
                // Перевірка пошти у списку користувачів
                checkUserExists(email)
            } else {
                // Показати повідомлення про помилку, коли поле пошти порожнє
                showToast("Please enter your email")
            }
        }

        buttonSignUp.setOnClickListener {
            // Логіка для переходу на сторінку реєстрації
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkUserExists(email: String) {
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    users?.let {
                        val userExists = users.any { it.email == email }
                        if (userExists) {
                            with(sharedPreferences.edit()) {
                                putBoolean("isLoggedIn", true)
                                apply()
                            }
                             navigateToMain()
                             showToast("Logged in successfully!")
                        } else {
                            // Показати повідомлення про помилку, коли користувача з такою поштою не знайдено
                            showToast("User with this email does not exist")
                        }
                    }
                } else {
                    // Показати повідомлення про помилку при отриманні списку користувачів
                    showToast("Failed to fetch users")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Показати повідомлення про помилку при виконанні запиту
                showToast("Network error: ${t.message}")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
