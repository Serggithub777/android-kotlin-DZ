package com.example.javatokotlin.ui.note

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.ui.base.BaseViewState

class NoteViewState(val note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)