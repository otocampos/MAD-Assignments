package br.com.ocdev.assignment_3

import AppNavigation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.ocdev.assignment_3.presentation.home_screen.HomeViewModel
import br.com.ocdev.assignment_3.ui.theme.Assignment_3Theme

@Composable
fun App() {

    Assignment_3Theme {
        val navController = rememberNavController()
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Users") },
                navigationIcon = if (navController.currentBackStackEntry != null) {
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                } else {
                    null
                })
        }) { contentPadding ->
            // Screen content
            Box(modifier = Modifier.padding(contentPadding)) {
                AppNavigation(
                    modifier = Modifier.padding(contentPadding),
                    navController = navController,
                )
            }
        }
    }
}