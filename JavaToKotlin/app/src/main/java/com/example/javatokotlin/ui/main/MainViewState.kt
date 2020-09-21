package com.example.javatokotlin.ui.main

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)