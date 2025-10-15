package vn.edu.tlu.buicongson.football247_mobile.ui.activities.login

import android.content.Context
import androidx.datastore.core.Storage
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.edu.tlu.buicongson.football247_mobile.constants.Tags
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepo
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse

class LoginViewModel(
    val loginRepo: LoginRepo,
    val context: Context) : ViewModel() {

    fun checkPhone(
        username: String,
        password: String,
        check: ((code: LoginResponse) -> Unit)? = null
    ) {
        viewModelScope.launch {
            val response = loginRepo.checkPhone(CheckPhone(username, password))

            if (response != null) {
                check?.invoke(response)

                val sharedPref = context.getSharedPreferences(Tags.MY_APP, Context.MODE_PRIVATE)

                with(sharedPref.edit()) {
                    putString(Tags.JWT_TOKEN, response.jwtToken)
                    apply()
                }
            }
        }
    }
}