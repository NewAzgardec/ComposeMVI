package com.digatex.composemvi.ui.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.digatex.composemvi.data.model.UserModel

@Preview
@Composable
fun ListItem(
    userModel: UserModel? = null,
    backgroundColor: Color = Color.LightGray,
    onItemClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    userModel?.let {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = 10.dp,
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { onItemClick() }
                    .padding(8.dp)
                    .background(backgroundColor)
            ) {
                Row(
                    modifier = modifier
                        .padding(16.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter("https://f.vividscreen.info/soft/d94b67f59645a24d442348c931ab59b5/Lemur-800x600.jpg"),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = it.name,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = it.phone,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }
    }
}
