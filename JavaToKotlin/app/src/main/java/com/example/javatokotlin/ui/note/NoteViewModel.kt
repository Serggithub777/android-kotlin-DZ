package com.example.javatokotlin.ui.note

import androidx.lifecycle.ViewModel
import com.example.javatokotlin.data.NoteRepository
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.model.NoteResult
import com.example.javatokotlin.ui.base.BaseViewModel

class NoteViewModel : BaseViewModel<Note?, NoteViewState>() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    fun loadNote(noteId: String) {
        NoteRepository.getNoteById(noteId).observeForever { result ->
            result ?: return@observeForever
            when (result) {
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = NoteViewState(note = result.data as? Note)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = NoteViewState(error = result.error)
                }
            }
        }
    }

    override fun onCleared() {
        pendingNote?.let {
            NoteRepository.saveNote(it)
        }
    }

}
