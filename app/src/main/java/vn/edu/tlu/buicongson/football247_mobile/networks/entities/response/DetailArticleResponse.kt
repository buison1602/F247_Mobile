package vn.edu.tlu.buicongson.football247_mobile.networks.entities.response

import com.google.gson.annotations.SerializedName

data class DetailArticleResponse (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("description") val description: String,
    @SerializedName("content") val content: String,
    @SerializedName("bgrImg") val bgrImg: String,
    @SerializedName("creatorName") val creatorName: String,
    @SerializedName("createdAt") val createAt: String,
    @SerializedName("updatedAt") val updateAt: String,
)