package vn.edu.tlu.buicongson.football247_mobile.ui.activities.detailArticle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.edu.tlu.buicongson.football247_mobile.data.impl.CommentRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.DetailArticleRepo
import vn.edu.tlu.buicongson.football247_mobile.mappers.toCategoryWrapper
import vn.edu.tlu.buicongson.football247_mobile.mappers.toCommentWrapper
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.detailArticle.Comment
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.AddCommentRequest
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CommentResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.DetailArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse

class DetailArticleViewModel(val detailArticleRepo: DetailArticleRepo, val commentRepo: CommentRepo) : ViewModel() {

    fun getArticle(articleSlug: String, onComplete: ((success: DetailArticleResponse) -> Unit)?) {
        viewModelScope.launch {
            val response = detailArticleRepo.getArticleBySlug(articleSlug)

            if (response != null) {
                onComplete?.invoke(response)
            }
        }
    }


    fun getComments(articleId: String, onComplete: ((success: List<Comment>) -> Unit)?) {
        viewModelScope.launch {
            val response = detailArticleRepo.getCommentsByArticleId(articleId)

            if (response != null) {
                val wrappedComments = response.map { it.toCommentWrapper() }

                onComplete?.invoke(wrappedComments)
            }
        }
    }


    fun createComment(
        articleId: String,
        content: String,
        onComplete: ((success: CommentResponse) -> Unit)? = null) {
        viewModelScope.launch {
            val response = commentRepo.createComment(AddCommentRequest(articleId, content))

            if (response != null) {
                onComplete?.invoke(response)
            }
        }
    }

}