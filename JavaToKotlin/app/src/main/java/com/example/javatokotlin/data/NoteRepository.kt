package com.example.javatokotlin.data

import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.provider.FirestoreDataProvider
import com.example.javatokotlin.data.provider.RemoteDataProvider

object NoteRepository {
    val remoteProvider: RemoteDataProvider = FirestoreDataProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
}