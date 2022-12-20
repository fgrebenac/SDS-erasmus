package com.erasmus.sds.network.threads

import com.erasmus.sds.models.AppThread
import com.erasmus.sds.models.ThreadBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ThreadsApiService {

    @GET("threads")
    suspend fun getThreads(): Response<List<AppThread>>

    @POST("threads")
    suspend fun addThread(@Body body: ThreadBody): Response<AppThread>

}