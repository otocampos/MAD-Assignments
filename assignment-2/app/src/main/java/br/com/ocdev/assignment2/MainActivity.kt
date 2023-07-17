package br.com.ocdev.assignment2

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ocdev.assignment2.Utils.FakerSingleton
import br.com.ocdev.assignment2.Utils.GenFakeList
import br.com.ocdev.assignment2.model.User
import br.com.ocdev.assignment2.ui.theme.Assignment2Theme
import com.github.javafaker.Faker
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Assignment2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyUI()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyUI() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Users") })
    }) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            LazyColumn()
        }
    }
}

@Composable
fun LazyColumn() {

    val listUsers = GenFakeList().gen()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {


        items(listUsers.size) { value ->
            ItemUi(
                modifier = Modifier.fillMaxWidth(),
                data = Pair(listUsers[value], value),
            )
        }
    }
}

@Composable
fun ItemUi(
    modifier: Modifier = Modifier,
    data: Pair<User, Int>,
) {
    Card(modifier = modifier) {
        Row {
            ColumnData(data = data.first)
            ColumnNumber(data.second)
        }

    }
}

@Composable
fun ColumnNumber(value: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .wrapContentSize(Alignment.TopEnd)
    ) {
        Box(
            modifier = Modifier

                .size(35.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value.plus(1).toString(),
                color = Color.White,
                textAlign = TextAlign.Justify
            )
        }
    }

}

@Composable
fun ColumnData(
    data: User,
) {
    Column {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "UserId: ${data.userId}",
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Username: ${data.userName}",
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Full name: ${data.fullName}",
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Email: ${data.email}",
        )

    }

}


