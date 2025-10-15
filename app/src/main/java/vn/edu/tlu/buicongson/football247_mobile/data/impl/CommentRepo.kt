package vn.edu.tlu.buicongson.football247_mobile.data.impl

import vn.edu.tlu.buicongson.football247_mobile.data.Service
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.AddCommentRequest
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CommentResponse

interface CommentRepo {
    suspend fun createComment(addComment: AddCommentRequest) : CommentResponse?
}

class CommentRepoImpl(val service: Service) : CommentRepo {
    override suspend fun createComment(addComment: AddCommentRequest): CommentResponse? {
        return service.createComment(addComment)
    }
}