package vn.edu.tlu.buicongson.football247_mobile.networks.entities.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse (
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("description") val description: String,
    @SerializedName("priority") val priority: String,
    @SerializedName("bgrImg") val bgrImg: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("tags") val tags: List<String>,
)