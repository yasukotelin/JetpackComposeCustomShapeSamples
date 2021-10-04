package com.github.yasukotelin.jetpackcomposecustomshapesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.yasukotelin.jetpackcomposecustomshapesamples.ui.theme.JetpackComposeCustomShapeSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCustomShapeSamplesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Contents()
                }
            }
        }
    }
}

@Composable
fun Contents() {
    LazyColumn(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item { ContentTitle(title = "Default Shapes") }
        item { Rectangle() }
        item { ContentSpacer() }
        item { Circle() }
        item { ContentSpacer() }
        item { RoundedCorner() }
        item { ContentSpacer() }
        item { CutCorner() }
        item { ContentSpacer() }
        item { EllipseWideWidth() }
        item { ContentSpacer() }
        item { RoundedCornerWideWidth() }

        item { ContentTitle(title = "Rotated Shapes") }
        item { Diamond() }
        item { ContentSpacer() }
        item { RotatedRoundedCorner() }

        item { ContentTitle(title = "Custom Shapes") }
        item { Triangle() }
        item { ContentSpacer() }
        item { ReverseTriangle() }
        item { ContentSpacer() }
        item { CustomCutCorner() }

        item { Spacer(modifier = Modifier.height(60.dp)) }
    }
}

@Composable
fun ContentTitle(title: String) {
    Spacer(modifier = Modifier.height(32.dp))
    Text(title, fontSize = 22.sp)
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun ContentSpacer() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun Rectangle() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RectangleShape)
            .background(LightGray)
    )
}

@Composable
fun Circle() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(LightGray)
    )
}

@Composable
fun RoundedCorner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightGray)
    )
}

@Composable
fun CutCorner() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CutCornerShape(10.dp))
            .background(LightGray)
    )
}

@Composable
fun Diamond() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CutCornerShape(100.dp))
            .background(LightGray)
    )
}

@Composable
fun RotatedRoundedCorner() {
    RoundedCorner(modifier = Modifier.rotate(25f))
}

@Composable
fun Triangle(modifier: Modifier = Modifier) {
    val triangleShape = GenericShape { size, _ ->
        moveTo(size.width / 2f, 0f)
        lineTo(size.width, size.height)
        lineTo(0f, size.height)
    }

    Box(
        modifier = modifier
            .size(100.dp)
            .clip(triangleShape)
            .background(LightGray)
    )
}

@Composable
fun ReverseTriangle() {
    Triangle(modifier = Modifier.rotate(180f))
}

@Composable
fun EllipseWideWidth() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .clip(CircleShape)
            .background(LightGray)
    )
}

@Composable
fun RoundedCornerWideWidth() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(LightGray)
    )
}

@Composable
fun CustomCutCorner() {
    val shape = GenericShape { size, _ ->
        lineTo(size.width, 0f)
        val cutSize = size.height / 4
        lineTo(size.width, size.height - cutSize)
        lineTo(size.width - cutSize, size.height)
        lineTo(0f, size.height)
    }

    Box(
        modifier = Modifier
            .width(90.dp)
            .height(100.dp)
            .clip(shape)
            .background(LightGray)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCustomShapeSamplesTheme {
        Contents()
    }
}