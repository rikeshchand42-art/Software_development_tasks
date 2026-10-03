package com.example.myapplication

import androidx.compose.material3.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.myapplication.ui.theme.MyApplicationTheme

class MusicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicScreen()
        }
    }
}

@Composable
fun MusicScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Recently played",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.NotificationsNone,
                        contentDescription = "Notifications",
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Outlined.History,
                        contentDescription = "History",
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.arjit),
                        contentDescription = "Arjit Singh",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(72.dp)
                            .clip(CircleShape)
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Text(
                        text = "Arjit Singh",
                        color = Color.White,
                        fontSize = 11.sp

                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.michel),
                        contentDescription = "Michel Jackson",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(72.dp)
                            .clip(CircleShape)
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Text(
                        text = "Michel Jackson",
                        color = Color.White,
                        fontSize = 11.sp

                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.sp),
                contentDescription = "Spotify Wrapped",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)

            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "#SPOTIFYWRAPPED",
                    color = Color.LightGray,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Your 2021 in review",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(R.drawable.two),
                        contentDescription = "Your Top Songs 2021",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Your Top Songs 2021",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(R.drawable.rev),
                        contentDescription = "Spotify Wrapped",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Your Artists Revealed",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Editor's picks",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)
                ){
                    Image(
                        painter = painterResource(R.drawable.ed),
                        contentDescription = "Juice WRLD",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ed Sheeran, Big Sean, Juice Wrld, Post Malone",
                        color = Color.LightGray,
                        fontSize = 11.sp,
                        lineHeight = 14.sp
                    )
                }
                Column(modifier = Modifier.weight(1f)
                ){
                Image(
                    painter = painterResource(id = R.drawable.justin),
                    contentDescription = "Justin Bieber",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Charli XCX, Justin Bieber, Selena Gomez",
                        color = Color.LightGray,
                        fontSize = 11.sp,
                        lineHeight = 14.sp
                    )
                }
            }

        }

}

@Preview
@Composable
fun MusicPreview() {
    MusicScreen()
}






