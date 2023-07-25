package br.com.ocdev.assignment_3.presentation.list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.ocdev.assignment_3.data.room.model.User
import br.com.ocdev.assignment_3.presentation.navigation.TopLevelDestination

@Composable
fun UserScreen(
    navController: NavController,
    usersViewModel: UsersViewModel
) {
    val dadosState by remember { usersViewModel.users }.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome to User List Screen")
        LazyColumnList(
            dados = dadosState, modifier = Modifier
                .weight(5f)
                .padding(16.dp),
            navController

        )

        Button(
            onClick = {
                usersViewModel.addUser()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
        ) {
            Text("Add User")
        }
    }


}


@Composable
fun LazyColumnList(dados: List<User>, modifier: Modifier, navController: NavController) {


    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {


        itemsIndexed(dados) { index,item ->
            ItemUi(
                modifier = Modifier.fillMaxSize(),
                data = Pair<User,Int>(item,index),
                navController

            )
        }
    }
}

@Composable
fun ItemUi(
    modifier: Modifier = Modifier,
    data: Pair<User, Int>,
    navController: NavController
) {
    Card(modifier = modifier) {
        Row {
            ColumnData(data = data, navController)
        }

    }
}

@Composable
fun ColumnData(
    data: Pair<User,Int>,
    navController: NavController
) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(TopLevelDestination.Detail.withArgs(data.first.userId.toString()))

        }, verticalArrangement = Arrangement.Center
    ) {
        Row() {
            Column() {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "UserId: ${data.first.userId}",
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Full name:\n${data.first.fullName}",
                )

            }
            Column() {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Username: ${data.first.userName}",
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Email: ${data.first.email}",
                )
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = data.second.plus(1).toString(),
                    color = Color.White,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}