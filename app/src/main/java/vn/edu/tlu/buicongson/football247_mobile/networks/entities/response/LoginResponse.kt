package vn.edu.tlu.buicongson.football247_mobile.networks.entities.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userId") val userId: String,
    @SerializedName("fullName") val fullName: String,
    @SerializedName("jwtToken") val jwtToken: String
)

