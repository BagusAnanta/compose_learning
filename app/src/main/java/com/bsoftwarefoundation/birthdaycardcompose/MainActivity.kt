package com.bsoftwarefoundation.birthdaycardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftwarefoundation.birthdaycardcompose.ui.theme.BirthdayCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(Greeting = getString(R.string.nama_ultah),getString(R.string.pengirim_ultah))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(Greeting: String,from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image,contentDescription = null, modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(Greeting = Greeting, from = from)
    }
}

@Composable
fun BirthdayGreetingWithText(Greeting : String,from : String){
    // this a composable function
    Column{
        Text(text = Greeting,
            fontSize = 36.sp,
            fontWeight = Bold,
            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally).padding(start = 16.dp, top = 16.dp),
        )
        Text(text = from,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally).padding(start = 16.dp, end = 16.dp)
        )
    }
}


@Preview(
    showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardComposeTheme {
        BirthdayGreetingWithImage(Greeting = "HBD Rakhaaaaa","-From Bagus")
    }
}