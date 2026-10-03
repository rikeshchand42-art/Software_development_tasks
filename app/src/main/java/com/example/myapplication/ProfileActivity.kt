package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text
import java.nio.file.WatchEvent

class ProfileAcitivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileBody()
        }
    }
}

@Composable
fun ProfileBody(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.outline_arrow_back_24),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text("rikesh_chand", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ))
            Icon(
                painter = painterResource(R.drawable.baseline_more_horiz_24),
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Instagram Ring Box
            Box(
                modifier = Modifier
                    .size(105.dp) // Outer ring size
                    .border(
                        width = 3.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFF58529),
                                Color(0xFFDD2A7B),
                                Color(0xFF8134AF),
                                Color(0xFF515BD4)
                            )
                        ),
                        shape = CircleShape
                    )
                    .padding(5.dp) // Gap between ring and image
            ) {
                Image(
                    painter = painterResource(R.drawable.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .fillMaxSize(), // Fill the inner box space
                    contentScale = ContentScale.Crop
                )
            }
            
            // Stats Row
            Row(
                modifier = Modifier.weight(1f).padding(start = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text("714",fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Posts")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("1M",fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Following")
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text("1",fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Followers")
                }
            }
        }

        Text("rikesh_chand",fontWeight = FontWeight.Bold,modifier = Modifier.fillMaxWidth().
        padding(start = 16.dp,end = 16.dp,top = 8.dp))

        Text("1907🌙",modifier = Modifier.fillMaxWidth().padding(start = 16.dp,end = 16.dp,top = 2.dp))
        Text("@fahhkit",modifier = Modifier.fillMaxWidth().padding(start = 16.dp,end = 16.dp,top = 2.dp))
        Text("@rikesh_chand",modifier = Modifier.fillMaxWidth().padding(start = 16.dp,end = 16.dp,top = 2.dp))
        Text(
            text = buildAnnotatedString {
                append("Followed by ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("hahaha__48")
                }
                append(" and ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("others")
                }
            },
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 2.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ElevatedButton(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0095F6),
                    contentColor = Color.White
                ),
                onClick = {}
            ) {
                Text("Follow")
            }
            ElevatedButton(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEFEFEF),
                    contentColor = Color.Black
                ),
                onClick = {}
            ) {
                Text("Message")
            }
            ElevatedButton(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEFEFEF),
                    contentColor = Color.Black
                ),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }


        Stories()
    }

}

@Composable
fun Stories() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.body),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Text(
                text = "Story 1",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                // Replaced android.R.drawable.btn_dropdown with R.drawable.image because Compose's painterResource
                // only supports VectorDrawables and rasterized asset types (PNG, JPG, WEBP), and btn_dropdown is a StateListDrawable XML.
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Text(
                text = "Story 2",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.flower),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Text(
                text = "Story 3",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Text(
                text = "Story 4",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}









@Preview
@Composable
fun ProfilePreview(){
    ProfileBody()
}