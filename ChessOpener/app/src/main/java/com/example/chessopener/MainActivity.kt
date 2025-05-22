package com.example.chessopener

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.chessopener.ui.theme.ChessOpenerTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessOpenerTheme {
                AppController()
            }
        }
    }
}


@Composable
fun AppController() {
    var showRandomizer by remember { mutableStateOf(false) }
    var showHelp by remember { mutableStateOf(false) }
    var showLearning by remember { mutableStateOf(false) }

    when {
        showRandomizer -> ChessOpener(onBack = { showRandomizer = false })
        showHelp -> HelpScreen(onBack = { showHelp = false })
        showLearning -> LearningScreen(onBack = { showLearning = false })
        else -> MenuScreen(
            onRandomizerClick = { showRandomizer = true },
            onHelpClick = { showHelp = true },
            onLearningClick = { showLearning = true }
        )
    }
}


@Composable
fun MenuScreen(
    onRandomizerClick: () -> Unit,
    onHelpClick: () -> Unit,
    onLearningClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.menu_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.25f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Chess Opener",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onRandomizerClick) {
                Text("Randomizer")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onLearningClick) {
                Text("Learning")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onHelpClick) {
                Text("Help")
            }
        }
    }
}



@Composable
fun ChessOpener(onBack: () -> Unit) {
    var result by remember { mutableStateOf((1..30).random()) }
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f))
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..30).random() }) {
            Text(stringResource(R.string.roll))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}


@Composable
fun HelpScreen(onBack: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.help_background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.2f))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Help", style = MaterialTheme.typography.headlineMedium,
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Chess Opener randomly selects a chess opening to help you discover new ones.",
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text("This app also helps you be less predictable if you play at a professional level.",
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Your opponents will never be able to guess what you are going to play—because even you don't know.",
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Use the 'Randomizer' button to get started.",
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text("You can also use the Learn button to explore all the chess openings available in our app. Good luck!",
            color = Color.White)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Back")
        }

    }
}

@Composable
fun LearningScreen(onBack: () -> Unit) {
    var currentImage by remember { mutableStateOf(1) }

    val imageResource = when (currentImage) {
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.3f))
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Abertura $currentImage"
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (currentImage > 1) currentImage--
                },
                enabled = currentImage > 1
            ) {
                Text("⬅️")
            }

            Button(onClick = onBack) {
                Text("Back")
            }

            Button(
                onClick = {
                    if (currentImage < 30) currentImage++
                },
                enabled = currentImage < 30
            ) {
                Text("➡️")
            }
        }
    }
}

