package vn.edu.tlu.buicongson.football247_mobile.networks.entities.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("updateAt") val updateAt: String,
)