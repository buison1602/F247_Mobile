package vn.edu.tlu.buicongson.football247_mobile.networks.entities.response

import com.google.gson.annotations.SerializedName

data class CommentResponse (
    @SerializedName("id") val id: String,
    @SerializedName("content") val content: String,
    @SerializedName("creatorId") val creatorId: String,
    @SerializedName("creatorName") val creatorName: String,
    @SerializedName("articleId") val articleId: String,
    @SerializedName("createdAt") val createAt: String,
)