package com.example.composequadrante

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrante.ui.theme.ComposeQuadranteTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadranteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, content: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,

        modifier = modifier.padding(12.dp)

    ) {

        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)


        )
        Text(
            text = content,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

//Each quadrant Row takes 2 Quadrants, making this so the code is more readable
@Composable
fun QuadrantRow(isFirstRow: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier

    ) {
        // If first row assign the text to the 2 texts of both first and second quadrant
        // else get the third and fourth quadrant
        if (isFirstRow) {
            Quadrant(
                title = stringResource(id = R.string.first_quadrant_title),
                content = stringResource(id = R.string.first_quadrant_content),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(0.5F)
                    .background(color = colorResource(id = R.color.first_quadrant))
            )
            Quadrant(
                title = stringResource(id = R.string.second_quadrant_title),
                content = stringResource(id = R.string.second_quadrant_content),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .background(color = colorResource(id = R.color.second_quadrant))
            )
        } else {
            Quadrant(
                title = stringResource(id = R.string.third_quadrant_title),
                content = stringResource(id = R.string.third_quadrant_content),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(.5F)
                    .background(color = colorResource(id = R.color.third_quadrant))
            )
            Quadrant(
                title = stringResource(id = R.string.fourth_quadrant_title),
                content = stringResource(id = R.string.fourth_quadrant_content),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .background(color = colorResource(id = R.color.fourth_quadrant))
            )
        }
    }
}

@Composable
fun AppQuadrant(modifier: Modifier = Modifier) {
    //Every Box Represents a quadrant
    Column(
        modifier = modifier
    ) {
        QuadrantRow(isFirstRow = true, modifier = Modifier

            .fillMaxWidth(1f)
            .fillMaxHeight(0.5f)

        )

        QuadrantRow(isFirstRow = false, modifier = Modifier

            .fillMaxWidth(1f)
            .fillMaxHeight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadranteTheme {
        AppQuadrant()
    }
}