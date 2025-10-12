package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.squareup.picasso.Picasso
import vn.edu.tlu.buicongson.football247_mobile.constants.DatasourceProperties.IP_LOCAL
import vn.edu.tlu.buicongson.football247_mobile.databinding.ArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.databinding.FirstArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News

sealed class ArticleNewsViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class FirstArticleViewHolder(private val binding: FirstArticleNewsItemBinding) :
        ArticleNewsViewHolder(binding) {

        fun bind(firstArticle: News.FirstArticle) {
            binding.tvTitle.text = firstArticle.article.title
//            Picasso.get()
//                .load(firstArticle.article.bgrImg.toImageUrl())
//                .into(binding.ivImage)
            Picasso.get()
                .load("http://192.168.1.118:7087/Images/son-01-0.jpg")
                .into(binding.ivImage)
            binding.tvAuthor.text = "MRBEAST"
            binding.tvCmtCount.text = "50 comments"
        }

    }

    class NormalArticleViewHolder(private val binding: ArticleNewsItemBinding) :
        ArticleNewsViewHolder(binding) {

        fun bind(normalArticle: News.NormalArticle) {
            binding.tvTitle.text = normalArticle.article.title
            Picasso.get()
                .load("http://192.168.1.118:7087/Images/son-01-0.jpg")
                .into(binding.ivImage)
            binding.tvAuthor.text = "Doraemon"
            binding.tvCmtCount.text = "99 comments"
        }

    }
}

fun String.toImageUrl(): String {
    val localIp = IP_LOCAL
    var a = this.replace("localhost", localIp).replace("https", "http")
    return a
}