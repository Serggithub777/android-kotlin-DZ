package com.example.javatokotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.javatokotlin.data.NoteRepository

class MainViewModel : ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NoteRepository.notes)
    }
    fun viewState (): LiveData<MainViewState> = viewStateLiveData
}