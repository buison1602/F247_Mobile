package vn.edu.tlu.buicongson.football247_mobile.ui.activities.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepo
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse

class LoginViewModel(val loginRepo: LoginRepo) : ViewModel() {

    fun checkPhone(
        username: String,
        password: String,
        check: ((code: LoginResponse) -> Unit)? = null
    ) {
        viewModelScope.launch {
            val response = loginRepo.checkPhone(CheckPhone(username, password))

            if (response != null) {
                check?.invoke(response)
            }
        }
    }
}