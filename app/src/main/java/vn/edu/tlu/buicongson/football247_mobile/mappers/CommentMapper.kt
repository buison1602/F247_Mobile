package vn.edu.tlu.buicongson.football247_mobile.mappers

import vn.edu.tlu.buicongson.football247_mobile.networks.entities.detailArticle.Comment
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CommentResponse

fun CommentResponse.toCommentWrapper(): Comment {
    return Comment(comment = this)
}
