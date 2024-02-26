package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadeApp(){

    LemonadeButtonImage1(modifier = Modifier
        .fillMaxSize(1f)
        .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun LemonadeButtonImage1(modifier: Modifier = Modifier){
    var stateImg by remember {
        mutableIntStateOf(1)
    }
    var stateStr by remember {
        mutableIntStateOf(1)
    }

    var countSqueeze by remember {
        mutableIntStateOf(0)
    }
    var amountToSqueeze = (2..4).random()


    val imageResource = when(stateImg){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val stringRes = when(stateStr){
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_lemonade
        else -> R.string.glass_empty
    }


    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = stringRes),
            modifier = Modifier
                .clickable {
                    if (stateImg == 2 || stateStr == 2) {
                        countSqueeze++
                        if (countSqueeze == amountToSqueeze) {
                            stateStr++
                            stateImg++
                        }
                    } else if (stateImg == 4 || stateStr == 4) {
                        stateImg = 1
                        stateStr = 1
                        countSqueeze = 0
                        amountToSqueeze = (2..4).random()
                    } else {
                        stateStr++
                        stateImg++
                    }

                }
                .clip(RoundedCornerShape(15.dp))
                .background(color = colorResource(id = R.color.purple_200))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = stringRes),
            fontSize = 18.sp
        )
    }
}