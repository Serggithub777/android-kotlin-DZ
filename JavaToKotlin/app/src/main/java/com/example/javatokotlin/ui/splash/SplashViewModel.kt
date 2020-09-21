package com.example.javatokotlin.ui.splash


import com.example.javatokotlin.data.NotesRepository
import com.example.javatokotlin.data.errors.NoAuthException
import com.example.javatokotlin.ui.base.BaseViewModel

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        notesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = it?.let {
                SplashViewState(authenticated = true)
            } ?: let {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}
