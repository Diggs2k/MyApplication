package com.example.chessopener

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chessopener.ui.theme.ChessOpenerTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.chessopener.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessOpenerTheme {
                ChessOpenerApp()
            }
        }
    }
}

@Preview
@Composable
fun ChessOpenerApp() {
    ChessBoardWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ChessBoardWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.chess1
        2 -> R.drawable.chess2
        3 -> R.drawable.chess3
        4 -> R.drawable.chess4
        5 -> R.drawable.chess5
        6 -> R.drawable.chess6
        7 -> R.drawable.chess7
        8 -> R.drawable.chess8
        9 -> R.drawable.chess9
        10 -> R.drawable.chess10
        11 -> R.drawable.chess11
        12 -> R.drawable.chess12
        13 -> R.drawable.chess13
        14 -> R.drawable.chess14
        15 -> R.drawable.chess15
        16 -> R.drawable.chess16
        17 -> R.drawable.chess17
        18 -> R.drawable.chess18
        19 -> R.drawable.chess19
        20 -> R.drawable.chess20
        21 -> R.drawable.chess21
        22 -> R.drawable.chess22
        23 -> R.drawable.chess23
        24 -> R.drawable.chess24
        25 -> R.drawable.chess25
        26 -> R.drawable.chess26
        27 -> R.drawable.chess27
        28 -> R.drawable.chess28
        29 -> R.drawable.chess29
        else -> R.drawable.chess30
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}