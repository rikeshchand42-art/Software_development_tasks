package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class CardsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CardsScreen()
            }
        }
    }
}

data class ColoredCardItem(
    val title: String,
    val subtitle: String,
    val description: String = "",
    val extraInfo: String = "",
    val startColor: Color,
    val endColor: Color
)

@Composable
fun CardsScreen() {
    val cardItems = listOf(
        ColoredCardItem("Dribbble", "Paldax\n**********", "", "", Color(0xFFFFD54F), Color(0xFFFF9800)),
        ColoredCardItem("HJM", "173****8838", "", "", Color(0xFF64B5F6), Color(0xFF1E88E5)),
        ColoredCardItem("Tom", "Room 601, Building 8, Zhongnan Century\nCity, No.8, Taoyuan Road...", "130****3920", "", Color(0xFF81C784), Color(0xFF388E3C)),
        ColoredCardItem("1882 **** **** 8695", "ICBC", "Debit Card", "12/19", Color(0xFFB388FF), Color(0xFF651FFF)),
        ColoredCardItem("Young", "This is the story of me and them, very...", "", "", Color(0xFFE29C74), Color(0xFFC77852)),
        ColoredCardItem("Jinjun street, golden chrysanthemum\nRoad, Haizhu District...", "", "", "", Color(0xFF90CAF9), Color(0xFF1976D2))
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF20CFA0),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = Color(0xFF20CFA0),
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Card",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(R.drawable.image),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }

            // White content area
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(Color(0xFFF5F6F8))
                    .padding(horizontal = 24.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(top = 24.dp, bottom = 88.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(cardItems) { item ->
                        ColoredCard(item)
                    }
                }
            }
        }
    }
}

@Composable
fun ColoredCard(item: ColoredCardItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Brush.linearGradient(listOf(item.startColor, item.endColor)))
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                if (item.subtitle.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.subtitle,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )
                }
            }

            if (item.description.isNotEmpty() || item.extraInfo.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = item.description,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f)
                    )
                    if (item.extraInfo.isNotEmpty()) {
                        Text(
                            text = item.extraInfo,
                            color = Color.White.copy(alpha = 0.9f),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardsPreview() {
    MyApplicationTheme {
        CardsScreen()
    }
}