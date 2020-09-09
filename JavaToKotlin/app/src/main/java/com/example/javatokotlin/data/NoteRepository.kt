package com.example.javatokotlin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.javatokotlin.data.entity.Note
import java.util.*

object NoteRepository {
    private val notesLiveData = MutableLiveData<List<Note>>()

    val notes: MutableList<Note> = mutableListOf(
            Note(UUID.randomUUID().toString(),
                 "Моя первая заметка",
                 "Kotlin очень краткий, но при этом выразительный язык",
                 Note.Color.WHITE),
            Note(UUID.randomUUID().toString(),
                 "Первая заметка",
                 "Текст первой заметки. Не очень длинный, но интересный",
                 Note.Color.GREEN),
            Note(UUID.randomUUID().toString(),
                 "Первая заметка",
                 "Текст первой заметки. Не очень длинный, но интересный",
                 Note.Color.BLUE),
            Note(UUID.randomUUID().toString(),
                 "Первая заметка",
                 "Текст первой заметки. Не очень длинный, но интересный",
                 Note.Color.RED),
            Note(UUID.randomUUID().toString(),
                 "Первая заметка",
                 "Текст первой заметки. Не очень длинный, но интересный",
                 Note.Color.VIOLET),
            Note(UUID.randomUUID().toString(),
                 "Первая заметка",
                 "Текст первой заметки. Не очень длинный, но интересный",
                 Note.Color.YELLOW)
            )
    init {
        notesLiveData.value = notes
    }

    fun   getNotes(): LiveData<List<Note>> {
           return notesLiveData
   }
    fun saveNote(note: Note){
        addOrReplace(note)
        notesLiveData.value = notes
    }


    private fun addOrReplace(note: Note){
        for (i in notes.indices){
            if(notes[i] == note){
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }
}