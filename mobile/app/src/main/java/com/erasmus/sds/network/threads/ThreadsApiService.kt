package com.erasmus.sds.network.threads

import com.erasmus.sds.models.AppUser
import com.erasmus.sds.models.RegistrationBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ThreadsApiService {

    @POST("threads")
    suspend fun getThreads(@Body body: RegistrationBody): Response<AppUser>

    @POST("create-thread")
    suspend fun addThread(@Body body: RegistrationBody): Response<AppUser>

}