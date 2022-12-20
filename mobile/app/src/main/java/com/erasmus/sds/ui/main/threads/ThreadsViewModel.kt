package com.erasmus.sds.ui.main.threads

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erasmus.sds.models.AppThread
import com.erasmus.sds.models.ThreadBody
import com.erasmus.sds.network.threads.ThreadsRepository
import kotlinx.coroutines.launch

class ThreadsViewModel(private val repository: ThreadsRepository) : ViewModel() {

    val threads = MutableLiveData<List<AppThread>>()
    val threadsError = MutableLiveData<Unit>()

    val addThread = MutableLiveData<AppThread>()
    val addThreadError = MutableLiveData<Unit>()

    fun getThreads() = viewModelScope.launch {
        val response = repository.getThreads()
        if (response.isSuccessful) threads.value = response.body()
        else threadsError.value = Unit
    }

    fun postThread(threadBody: ThreadBody) = viewModelScope.launch {
        val response = repository.addThread(threadBody)
        if (response.isSuccessful) addThread.value = response.body()
        else addThreadError.value = Unit
    }
}