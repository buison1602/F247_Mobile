package vn.edu.tlu.buicongson.football247_mobile.networks.entities.request

import com.google.gson.annotations.SerializedName

data class CheckPhone(
    @SerializedName("email") val email: String?,
    @SerializedName("password") val password: String?
)