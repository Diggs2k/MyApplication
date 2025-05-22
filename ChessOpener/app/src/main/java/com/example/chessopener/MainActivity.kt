package com.example.chessopener

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
                AppController()
            }
        }
    }
}


@Composable
fun AppController() {
    var showRandomizer by remember { mutableStateOf(false) }
    var showHelp by remember { mutableStateOf(false) }

    when {
        showRandomizer -> ChessOpener(onBack = { showRandomizer = false })
        showHelp -> HelpScreen(onBack = { showHelp = false })
        else -> MenuScreen(
            onRandomizerClick = { showRandomizer = true },
            onHelpClick = { showHelp = true }
        )
    }
}

@Composable
fun MenuScreen(
    onRandomizerClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Chess Opener", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onRandomizerClick) {
            Text("Randomizador")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onHelpClick) {
            Text("Ajuda")
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
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
            Text("Voltar")
        }
    }
}


@Composable
fun HelpScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ajuda", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("O Chess Opener sorteia uma abertura de xadrez aleatória para o ajudar a conhecer novas aberturas.")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Esta aplicação também o ajuda a ser menos previsivel se jogar a nivel profissional.")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Os seus adversários nunca conseguirão prever o que você irá jogar, pois nem você sabe.")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Use o botão 'Randomizer' para começar. Boa sorte!")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}
