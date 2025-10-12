package vn.edu.tlu.buicongson.football247_mobile.ui.activities.detailArticle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.edu.tlu.buicongson.football247_mobile.R
import vn.edu.tlu.buicongson.football247_mobile.databinding.ActivityDetailArticleBinding
import vn.edu.tlu.buicongson.football247_mobile.databinding.ActivityNewsBinding
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.News
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.news.NewsViewModel
import vn.edu.tlu.buicongson.football247_mobile.ui.adapters.comments.CommentAdapter
import vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news.CategoryNewsAdapter
import vn.edu.tlu.buicongson.football247_mobile.ui.adapters.news.toImageUrl
import vn.edu.tlu.buicongson.football247_mobile.utils.convertCreatedAt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.collections.first
import kotlin.collections.isNotEmpty
import kotlin.getValue

class DetailArticleActivity : AppCompatActivity() {

    private val viewModel : DetailArticleViewModel by viewModel()

    private val binding: ActivityDetailArticleBinding by lazy {
        ActivityDetailArticleBinding.inflate(layoutInflater)
    }

    private val commentsAdapter by lazy {
        CommentAdapter()
    }

    private lateinit var articleSlug: String
    private lateinit var articleId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        articleSlug = intent.getStringExtra("Article_Slug").toString()
        articleId = intent.getStringExtra("Article_Id").toString()

        initView()
    }

    private fun initView() {
        if (articleSlug != null) {
            getArticleBySlug()
            getListComments()
        }

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.rvComments.setHasFixedSize(true)
        binding.rvComments.layoutManager = LinearLayoutManager(this)
        binding.rvComments.adapter = commentsAdapter
    }

    private fun getArticleBySlug() {
        viewModel.getArticle(articleSlug, onComplete = { article ->
            binding.apply {
                tvTitle.text = article.title
                tvAuthor.text = article.creatorName
                tvCreatedAt.text = convertCreatedAt(article.createAt)
                tvContentArticle.text = article.content

//                Picasso.get()
//                    .load(article.bgrImg.toImageUrl())
//                    .into(ivBgrImg)

                Picasso.get()
                    .load("http://192.168.1.191:7087/Images/son-01-0.jpg")
                    .into(binding.ivBgrImg)
            }
        })
    }

    private fun getListComments() {
        viewModel.getComments(articleId,
            onComplete = { comments ->
                commentsAdapter.items = comments
            }
        )

    }

}