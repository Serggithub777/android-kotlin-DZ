package com.example.javatokotlin.ui.note

import com.example.javatokotlin.data.NotesRepository
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.model.NoteResult
import com.example.javatokotlin.ui.base.BaseViewModel

class NoteViewModel(val notesRepository: NotesRepository) : BaseViewModel<NoteViewState.Data, NoteViewState>() {

    private val pendingNote: Note?
        get() = viewStateLiveData.value?.data?.note


    fun save(note: Note) {
        viewStateLiveData.value = NoteViewState(NoteViewState.Data(note = note))
    }

    fun loadNote(noteId: String) {
        notesRepository.getNoteById(noteId).observeForever { result ->
            result ?: return@observeForever
            when (result) {
                is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(NoteViewState.Data(note = result.data as? Note))
                is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = result.error)
            }
        }
    }

    public override fun onCleared() {
        pendingNote?.let {
            notesRepository.saveNote(it)
        }
    }

    fun deleteNote() {
        pendingNote?.let {
            notesRepository.deleteNote(it.id).observeForever { result ->
                result ?: return@observeForever
                when (result) {
                    is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(NoteViewState.Data(isDeleted = true))
                    is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = result.error)
                }
            }
        }
    }

}
