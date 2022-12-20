package com.erasmus.sds.network.threads

import com.erasmus.sds.models.ThreadBody

class ThreadsRepository(private val apiService: ThreadsApiService) {

    suspend fun getThreads() = apiService.getThreads()

    suspend fun addThread(body: ThreadBody) = apiService.addThread(body)

}