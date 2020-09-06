package com.example.javatokotlin.ui.note

import androidx.lifecycle.ViewModel
import com.example.javatokotlin.data.NoteRepository
import com.example.javatokotlin.data.model.Note

class NoteViewModel: ViewModel() {
    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NoteRepository.saveNote(it)
        }
    }
}