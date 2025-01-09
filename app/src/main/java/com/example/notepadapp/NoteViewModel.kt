package com.example.notepadapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class NoteViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    fun addNote(
        title: String,
        body: String,
        dateAdded: Long
    ) {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val dateString = formatter.format(dateAdded)
        _notes.add(Note(title = title, body = body, dateAdded = dateString))
        println("Notes count: ${_notes.size}") // Debug log
    }
}
