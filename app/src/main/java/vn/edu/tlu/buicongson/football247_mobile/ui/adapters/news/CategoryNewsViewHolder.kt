package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.squareup.picasso.Picasso
import vn.edu.tlu.buicongson.football247_mobile.databinding.CategoryNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.databinding.FirstArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.Category
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News

sealed class CategoryNewsViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class CategoryViewHolder(private val binding: CategoryNewsItemBinding) :
        CategoryNewsViewHolder(binding) {

        fun bind(category: Category) {
            binding.tvCategory.text = category.category.name
        }

    }

}