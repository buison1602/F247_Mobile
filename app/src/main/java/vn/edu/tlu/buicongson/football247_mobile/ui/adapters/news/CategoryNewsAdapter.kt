package vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.edu.tlu.buicongson.football247_mobile.R
import vn.edu.tlu.buicongson.football247_mobile.databinding.CategoryNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.databinding.FirstArticleNewsItemBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.Category
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CategoryResponse

class CategoryNewsAdapter : RecyclerView.Adapter<CategoryNewsViewHolder>() {

    var items = listOf<Category>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNewsViewHolder {
        return CategoryNewsViewHolder.CategoryViewHolder (
            CategoryNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
       when (holder) {
           is CategoryNewsViewHolder.CategoryViewHolder -> holder.bind(items[position] as Category)
       }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Category ->  R.layout.category_news_item
            else -> throw java.lang.IllegalArgumentException("Sai sai")
        }
    }
}