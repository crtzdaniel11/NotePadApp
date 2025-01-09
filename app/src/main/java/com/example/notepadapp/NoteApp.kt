package com.example.notepadapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notepadapp.ui.theme.NotepadAppTheme
import com.example.notepadapp.Note

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun NoteApp(navController: NavHostController) {
    val viewModel: NoteViewModel = viewModel()
    val notes = viewModel.notes // Observing state

    NotepadAppTheme {
        Scaffold(
            topBar = { AppBar() },
            floatingActionButton = {
                AddNoteButton {
                    navController.navigate("editor")
                }
            },
            content = { padding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    if (notes.isEmpty()) {
                        Text(
                            text = "No notes yet",
                            fontSize = 18.sp,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                        )
                    } else {
                        NoteList(notes = notes)
                    }
                }
            }
        )
    }
}



@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Notepad") },
        actions = {
            IconButton(onClick = { /* Handle Search */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* Handle Sort */ }) {
                Icon(Icons.Filled.Sort, contentDescription = "Sort")
            }
        }
    )
}

@Composable
fun AddNoteButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(Icons.Filled.Add, contentDescription = "Add Note")
    }
}

@Composable
fun NoteList(notes: List<Note>) {
    println("Rendering ${notes.size} notes")
    Column(modifier = Modifier.fillMaxSize()) {
        for (note in notes) {
            NoteItem(note = note)
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = note.title, style = MaterialTheme.typography.h6)
        Text(text = note.body, style = MaterialTheme.typography.body1)
        Text(text = note.dateAdded, style = MaterialTheme.typography.caption)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}





