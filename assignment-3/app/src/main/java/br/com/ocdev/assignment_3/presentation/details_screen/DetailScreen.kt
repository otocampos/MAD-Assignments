package br.com.ocdev.assignment_3.presentation.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.ocdev.assignment_3.data.room.model.User
import br.com.ocdev.assignment_3.presentation.details_screen.DetailViewModel

@Composable
fun DetailScreen(
    navController: NavController, detailViewModel: DetailViewModel, userId: String
) {
    val user by remember { detailViewModel.user }.collectAsState()
    LaunchedEffect(Unit) {
        detailViewModel.getUser(userId.toInt())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Box(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(), contentAlignment = Alignment.CenterStart
        ) {
            Text("Welcome to User Detail Screen")
        }
        ItemUi(user = user)
        Button(
            onClick = {
                detailViewModel.deleteUser(user)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text("Delete")
        }
    }


}

@Composable
fun ItemUi(
    modifier: Modifier = Modifier,
    user: User?,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row {
            ColumnData(user)
        }

    }
}

@Composable
fun ColumnData(
    data: User?,
) {
    Column(modifier = Modifier.clickable {

    }) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "UserId: ${data?.userId}",
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Username: ${data?.userName}",
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Full name: ${data?.fullName}",
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Email: ${data?.email}",
        )

    }
}