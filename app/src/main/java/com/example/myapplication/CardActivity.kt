package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocalShipping
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.VpnKey
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF20CFA0)
                ) { innerPadding ->
                    CardScreen(
                        modifier = Modifier.padding(
                            top = innerPadding.calculateTopPadding(),
                            bottom = innerPadding.calculateBottomPadding()
                        )
                    )
                }
            }
        }
    }
}

data class DashboardItem(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val iconTint: Color
)

@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    val items = listOf(
        DashboardItem("Text", "11 items content", Icons.Rounded.MenuBook, Color(0xFF6D4C41)),
        DashboardItem("Address", "3 items content", Icons.Rounded.Home, Color(0xFFE53935)),
        DashboardItem("Character", "15 items content", Icons.Rounded.Person, Color(0xFFFB8C00)),
        DashboardItem("Bank card", "5 items content", Icons.Rounded.CreditCard, Color(0xFF1E88E5)),
        DashboardItem("Password", "21 items content", Icons.Rounded.VpnKey, Color(0xFFFFB300)),
        DashboardItem("Logistics", "13 items content", Icons.Rounded.LocalShipping, Color(0xFF43A047))
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Card",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Simple and easy to use app.",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
            }
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color(0xFFF5F6F8))
                .padding(horizontal = 24.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp, bottom = 24.dp)
            ) {
                items(items) { item ->
                    DashboardCard(item)
                }

                item(span = { GridItemSpan(2) }) {
                    SettingsCard()
                }
            }
        }
    }
}

@Composable
fun DashboardCard(item: DashboardItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(16.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = item.iconTint,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.subtitle,
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}

@Composable
fun SettingsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(16.dp))
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = "Settings",
            tint = Color.Gray,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = "Settings",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Fingerprint code and so on",
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    MyApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF20CFA0)
        ) { innerPadding ->
            CardScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
