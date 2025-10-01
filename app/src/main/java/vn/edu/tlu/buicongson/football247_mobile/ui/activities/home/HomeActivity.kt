package vn.edu.tlu.buicongson.football247_mobile.ui.activities.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.edu.tlu.buicongson.football247_mobile.R
import vn.edu.tlu.buicongson.football247_mobile.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val viewModel : HomeViewModel by viewModel()
    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}