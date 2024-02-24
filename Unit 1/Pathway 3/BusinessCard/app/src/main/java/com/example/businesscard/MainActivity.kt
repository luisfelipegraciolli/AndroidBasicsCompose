package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorResource(id = R.color.background)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Profile(
                            name = stringResource(id = R.string.name),
                            title = stringResource(id = R.string.title)
                        )
                        ProfileSocialMedia(
                            email = stringResource(id = R.string.email),
                            portfolio = stringResource(id = R.string.github),

                            )
                    }
                }
            }
        }

    }
}


@Composable
fun Profile(name: String, title: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier

            .fillMaxHeight(0.60f)
    ) {
        val image = painterResource(id = R.drawable.pfp)
        Image(
            painter = image,
            contentDescription = "profile icon",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .align(alignment = Alignment.CenterHorizontally)
                .size(150.dp)

        )
        Text(
            text = name.uppercase(),
            color = Color.White,
            letterSpacing = 7.sp,
            lineHeight = 40.sp,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
        Text(
            text = title.uppercase(),
            color = colorResource(id = R.color.title_color),
            letterSpacing = 5.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 30.sp,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(id = R.string.about_me),
            color = colorResource(id = R.color.white),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Justify,
            lineHeight = 30.sp,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(25.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "Feel free to contact me!", color = colorResource(id = R.color.white),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Justify,
            lineHeight = 30.sp,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                
                .align(alignment = Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun ProfileSocialMedia(email: String, portfolio: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Icon(
                painter = painterResource(id = R.drawable.email_icon),
                contentDescription = "email",
                tint = colorResource(id = R.color.title_color),
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)

            )
            Text(
                text = email,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 4.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }
        Row() {
            Icon(
                painter = painterResource(id = R.drawable.baseline_code_24),
                contentDescription = "email",
                tint = colorResource(id = R.color.title_color),
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)
            )
            Text(
                text = portfolio,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                letterSpacing = 4.sp,
                modifier = Modifier.align(Alignment.CenterVertically)

            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val email = stringResource(id = R.string.email)
    val portfolio = stringResource(id = R.string.github)
    BusinessCardTheme() {
        ProfileSocialMedia(email = email, portfolio = portfolio)
    }
}