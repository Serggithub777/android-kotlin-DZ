package com.example.javatokotlin.ui.note

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error) {
    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}