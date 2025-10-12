package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.comments

import androidx.recyclerview.widget.RecyclerView
import vn.edu.tlu.buicongson.football247_mobile.databinding.ArticleCommentItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.detailArticle.Comment
import vn.edu.tlu.buicongson.football247_mobile.utils.convertCreatedAt

class CommentViewHolder(private val binding: ArticleCommentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(comment: Comment) {
        binding.tvContent.text = comment.comment.content
        binding.tvAuthor.text = comment.comment.creatorName
        binding.tvCreatedAt.text = convertCreatedAt(comment.comment.createAt)
    }
}