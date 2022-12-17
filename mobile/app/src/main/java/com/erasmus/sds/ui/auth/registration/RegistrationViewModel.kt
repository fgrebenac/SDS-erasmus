package com.erasmus.sds.ui.auth.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erasmus.sds.models.AppUser
import com.erasmus.sds.models.RegistrationBody
import com.erasmus.sds.network.registration.RegistrationRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: RegistrationRepository) : ViewModel() {

    val registerResult = MutableLiveData<AppUser>()
    val registerError = MutableLiveData<Unit>()

    fun registerUser(firstName: String, lastName: String, email: String, password: String) =
        viewModelScope.launch {
            val response =
                repository.registerUser(RegistrationBody(firstName, lastName, email, password))
            if (response.isSuccessful) {
                registerResult.value = response.body()
            } else {
                registerError.value = Unit
            }
        }

}