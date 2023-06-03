package com.gearsoftca.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gearsoftca.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {

    var currentStep by remember { mutableStateOf(1) }


    when (currentStep) {
        1 -> {
            UILemon(
                DescriptionID = R.string.lemon_tree_description,
                DescriptionImageID = R.string.lemon_tree,
                ImageID = R.drawable.lemon_tree,
                onImageClick = {
                    currentStep = 2
                }
            )


        }

        2 -> {
            UILemon(
                DescriptionID = R.string.tapping_description,
                DescriptionImageID = R.string.lemon,
                ImageID = R.drawable.lemon_squeeze,
                onImageClick ={
                    currentStep = 3
                }
            )
        }

        3 -> {
            UILemon(
                DescriptionID = R.string.drink_description,
                DescriptionImageID = R.string.glass_of_lemonade,
                ImageID = R.drawable.lemon_drink,
                onImageClick = {
                    currentStep = 4
                }
            )
        }

        4 -> {
            UILemon(
                DescriptionID = R.string.empty_glass_description,
                DescriptionImageID = R.string.empty_glass,
                ImageID = R.drawable.lemon_restart,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }

}


@Composable
fun UILemon(
    DescriptionID: Int,
    DescriptionImageID: Int,
    ImageID: Int,
    onImageClick: () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(DescriptionID),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Button(onClick = onImageClick) {
            Image(
                painter = painterResource(ImageID),
                contentDescription = stringResource(DescriptionImageID),
                modifier = Modifier
                    .padding(16.dp)
                    .border(4.dp, color = Color.Cyan, RectangleShape)
            )
        }
    }

}
