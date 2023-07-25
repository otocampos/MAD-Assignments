package br.com.ocdev.assignment_3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.ocdev.assignment_3.ui.theme.Assignment_3Theme

@Composable
fun App() {
    Assignment_3Theme {
     //   val navController = rememberNavController()
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Users") })
        }) { contentPadding ->
            // Screen content
            Box(modifier = Modifier.padding(contentPadding)) {

            }
        }
    }
}