package com.example.notepadapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NoteNavHost(navController: NavHostController = rememberNavController()) {
    val viewModel: NoteViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { NoteApp(navController, viewModel) }
        composable("editor") { NoteEditorScreen(navController, viewModel) }
    }
}


