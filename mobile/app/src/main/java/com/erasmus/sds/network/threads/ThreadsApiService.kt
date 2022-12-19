package com.erasmus.sds.network.threads

import com.erasmus.sds.models.AppUser
import com.erasmus.sds.models.AppThread
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ThreadsApiService {

    @POST("threads")
    suspend fun getThreads(@Body body: AppThread): Response<AppThread>

    @POST("create-thread")
    suspend fun addThread(@Body body: AppThread): Response<AppThread>

}