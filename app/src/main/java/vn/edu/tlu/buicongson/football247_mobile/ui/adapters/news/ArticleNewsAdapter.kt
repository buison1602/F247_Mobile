package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.edu.tlu.buicongson.football247_mobile.R
import vn.edu.tlu.buicongson.football247_mobile.databinding.ArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.databinding.FirstArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News

class ArticleNewsAdapter : RecyclerView.Adapter<ArticleNewsViewHolder>() {

    var onItemClick: ((News) -> Unit)? = null

    var items = listOf<News>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleNewsViewHolder {
        return when (viewType) {
            R.layout.first_article_news_item -> ArticleNewsViewHolder.FirstArticleViewHolder (
                FirstArticleNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            R.layout.article_news_item -> ArticleNewsViewHolder.NormalArticleViewHolder (
                ArticleNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> throw java.lang.IllegalArgumentException("Sai sai")
        }
    }

    override fun onBindViewHolder(holder: ArticleNewsViewHolder, position: Int) {
        when (holder) {
            is ArticleNewsViewHolder.FirstArticleViewHolder -> holder.bind(items[position] as News.FirstArticle)
            is ArticleNewsViewHolder.NormalArticleViewHolder -> holder.bind(items[position] as News.NormalArticle)
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(items[position])
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is News.FirstArticle ->  R.layout.first_article_news_item
            is News.NormalArticle -> R.layout.article_news_item
        }
    }
}