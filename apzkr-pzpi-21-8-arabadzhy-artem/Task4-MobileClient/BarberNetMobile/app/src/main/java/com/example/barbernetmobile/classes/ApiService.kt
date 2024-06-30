package com.example.barbernetmobile

import com.example.barbernetmobile.classes.Appointment
import com.example.barbernetmobile.classes.User
import com.example.barbernetmobile.classes.Salon
import com.example.barbernetmobile.classes.Services
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("api/data/{data}")
    fun getAppointments(@Path("data") data: String): Call<List<Appointment>>

    @POST("api/data/{data}")
    fun createAppointment(@Path("data") data: String, @Body appointment: Appointment): Call<Appointment>
    @DELETE("api/data/appointments/{id}")
    fun deleteAppointment(@Path("id") id: String): Call<Void>

    @GET("api/data/users")
    fun getUsers(): Call<List<User>>
    @POST("api/data/users")
    fun createUser(@Body user: User): Call<User>

    @GET("api/data/salons")
    fun getSalon(): Call<List<Services>>
    @POST("api/data/salons")
    fun createSalon(@Body Salon: User): Call<Services>
    @GET("api/data/salons")

    fun getServices(): Call<List<Services>>
    @POST("api/data/salons")
    fun createServices(@Body Salon: User): Call<Services>

}
