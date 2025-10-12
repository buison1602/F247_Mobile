package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.comments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.edu.tlu.buicongson.football247_mobile.databinding.ArticleCommentItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.detailArticle.Comment

class CommentAdapter: RecyclerView.Adapter<CommentViewHolder>() {

    var items = listOf<Comment>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            ArticleCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        Log.d("111111111111111111111111", items[position].comment.id)
        Log.d("111111111111111111111111", items[position].comment.creatorId)


        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}