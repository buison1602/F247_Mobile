package vn.edu.tlu.buicongson.football247_mobile.data.impl

import vn.edu.tlu.buicongson.football247_mobile.data.Service
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse

interface LoginRepo {
    suspend fun checkPhone(apply: CheckPhone) : LoginResponse?
}

class LoginRepoIml(val service: Service) : LoginRepo {
    override suspend fun checkPhone(login: CheckPhone): LoginResponse? {
        return service.checkPhone(login)
    }
}