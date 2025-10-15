package vn.edu.tlu.buicongson.football247_mobile.networks.entities.request

import com.google.gson.annotations.SerializedName

data class AddCommentRequest(
    @SerializedName("articleId") val articleId: String,
    @SerializedName("content") val content: String
)