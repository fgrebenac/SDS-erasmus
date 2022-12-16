package com.erasmus.sds.network.login

import com.erasmus.sds.models.LoginBody

class LoginRepository(private val apiService: LoginApiService) {

    suspend fun loginUser(body: LoginBody) = apiService.login(body)

}