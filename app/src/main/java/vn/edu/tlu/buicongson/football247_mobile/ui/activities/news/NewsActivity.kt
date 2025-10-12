package vn.edu.tlu.buicongson.football247_mobile.ui.activities.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.edu.tlu.buicongson.football247_mobile.databinding.ActivityNewsBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.detailArticle.DetailArticleActivity
import vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news.ArticleNewsAdapter
import vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news.CategoryNewsAdapter

class NewsActivity : AppCompatActivity() {

    private val viewModel : NewsViewModel by viewModel()
    private val binding: ActivityNewsBinding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private val categoriesAdapter by lazy {
        CategoryNewsAdapter()
    }

    private val articlesAdapter by lazy {
        ArticleNewsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        getListArticles()
        binding.rvArticles.setHasFixedSize(true)
        binding.rvArticles.layoutManager = LinearLayoutManager(this)
        binding.rvArticles.adapter = articlesAdapter

        getListCategories()
        binding.rvCategories.setHasFixedSize(true)
        binding.rvCategories.adapter = categoriesAdapter

        setupBottomMenu()
    }

    private fun getListArticles() {
        viewModel.getArticles(onComplete = { articles ->
            val transformedArticles = mutableListOf<News>()
            if (articles.isNotEmpty()) {
                transformedArticles.add(News.FirstArticle(articles.first()))
                if (articles.size > 1) {
                    transformedArticles.addAll(articles.subList(1, articles.size)
                        .map { News.NormalArticle(it) })
                }
            }
            articlesAdapter.items = transformedArticles
        })

        onClickArticle()
    }

    private fun onClickArticle() {
        articlesAdapter.onItemClick = { clickedNewsItem ->
            val slug = when (clickedNewsItem) {
                is News.FirstArticle -> clickedNewsItem.article.slug
                is News.NormalArticle -> clickedNewsItem.article.slug
            }

            val articleId = when (clickedNewsItem) {
                is News.FirstArticle -> clickedNewsItem.article.id
                is News.NormalArticle -> clickedNewsItem.article.id
            }

            var intent = Intent(this@NewsActivity, DetailArticleActivity::class.java).apply {
                putExtra("Article_Slug", slug)
                putExtra("Article_Id", articleId)
            }
            startActivity(intent)
        }
    }

    private fun getListCategories() {
        viewModel.getCategories(
            onComplete = { categories ->
                categoriesAdapter.items = categories
            }
        )
    }

    private lateinit var tabs: List<TextView>

    private fun setupBottomMenu() {
        tabs = with(binding.bottomMenu) {
            listOf(news, scores, discover, account)
        }

        tabs.forEach { tab ->
            tab.setOnClickListener {
                updateSelectedTab(it)
            }
        }

        updateSelectedTab(binding.bottomMenu.news)
    }

    private fun updateSelectedTab(selectedTab: View) {
        tabs.forEach { tab ->
            tab.isSelected = (tab.id == selectedTab.id)
        }
    }

}