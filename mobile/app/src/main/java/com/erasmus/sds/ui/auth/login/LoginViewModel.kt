package com.erasmus.sds.ui.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erasmus.sds.models.LoginBody
import com.erasmus.sds.network.login.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    val loginResult = MutableLiveData<String>()
    val loginError = MutableLiveData<Unit>()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        val response =
            repository.loginUser(LoginBody(email, password))
        if (response.isSuccessful) {
            loginResult.value = response.body()
        } else {
            loginError.value = Unit
        }
    }
}