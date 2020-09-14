package com.example.javatokotlin.ui.splash

import com.example.javatokotlin.data.NoteRepository
import com.example.javatokotlin.data.errors.NoAuthException
import com.example.javatokotlin.ui.base.BaseViewModel

class SplashViewModel : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        NoteRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = it?.let {
                SplashViewState(authenticated = true)
            } ?: let {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}
