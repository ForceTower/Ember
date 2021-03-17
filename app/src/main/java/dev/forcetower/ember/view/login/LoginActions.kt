package dev.forcetower.ember.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LoginActions {
    val username: MutableLiveData<String>
    val password: MutableLiveData<String>
    val loading: LiveData<Boolean>
    fun onLogin()
}