package com.erasmus.sds.network.login

import com.erasmus.sds.models.LoginBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("users/log-in")
    suspend fun login(@Body body: LoginBody): Response<String>

}