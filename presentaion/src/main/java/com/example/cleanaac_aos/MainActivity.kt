package com.example.cleanaac_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanaac_aos.features.main.MainViewModel
import com.example.cleanaac_aos.model.UserPresentationModel
import com.example.cleanaac_aos.ui.theme.CleanAAC_AOSTheme
import com.example.domain.entity.User
import javax.inject.Inject

/**
 * list data model 과 view의 text를 연결해준다..?
 */

class MainActivity @Inject constructor(
    private val mainViewModel: MainViewModel
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanAAC_AOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
        Text(text = "AVD Test $name ")
    }
}

// view 생성 .. 
@Composable
fun makeList(models: UserPresentationModel) {
    Column(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        content = {
            Text(text = models.id,
            fontSize = 20.sp,
            maxLines = 1,
            fontWeight = FontWeight.Bold)

            Text(text = models.name,
            fontSize = 16.sp,
            maxLines = 1,
            color = Color.LightGray)

            Text(text = models.date,
            fontSize = 16.sp,
            maxLines = 2,
            color = Color.Blue)

            Text(text = models.url,
                fontSize = 16.sp,
                maxLines = 1,
                color = Color.Cyan)
        }
    )
}
        

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CleanAAC_AOSTheme {
        Greeting("Android")
    }
}