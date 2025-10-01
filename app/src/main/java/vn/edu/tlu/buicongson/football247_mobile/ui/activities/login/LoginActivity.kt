package vn.edu.tlu.buicongson.football247_mobile.ui.activities.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.edu.tlu.buicongson.football247_mobile.databinding.ActivityLoginBinding
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.home.HomeActivity

class LoginActivity : AppCompatActivity() {
    private val viewModel : LoginViewModel by viewModel()
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hiển thị giao diện
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnSubmit.setOnClickListener {
            submitLogin()
        }
    }

    fun submitLogin() {
        val username = binding.edtUserName.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        binding.edtUserName.error = null
        binding.edtPassword.error = null

        when {
            username.isEmpty() -> {
                binding.edtUserName.error = "Vui lòng nhập tên đăng nhập"
                binding.edtUserName.requestFocus()
                return
            }

            password.isEmpty() -> {
                binding.edtPassword.error = "Vui lòng nhập mt khẩu"
                binding.edtPassword.requestFocus()
                return
            }

            else -> {
                viewModel.checkPhone(username, password, check = {
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                })
            }
        }
    }
}