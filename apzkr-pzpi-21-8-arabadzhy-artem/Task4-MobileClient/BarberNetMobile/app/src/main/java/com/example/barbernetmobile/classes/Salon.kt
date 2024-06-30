package com.example.barbernetmobile.classes

import com.google.gson.annotations.SerializedName

data class Salon(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("image")
    val image: String
)
