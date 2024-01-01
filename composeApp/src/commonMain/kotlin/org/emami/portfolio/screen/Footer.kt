package org.emami.portfolio.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Abc
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.emami.portfolio.openUrl
import org.jetbrains.compose.resources.painterResource

@Composable
fun Footer(isNotCompact: Boolean) {

    Column(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.8f))
            .padding(if (isNotCompact) 50.dp else 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = {
                },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text("About me", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.width(if (isNotCompact) 20.dp else 10.dp))
            TextButton(
                onClick = {
                },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text("Skills", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.width(if (isNotCompact) 20.dp else 10.dp))
            TextButton(
                onClick = {
                },
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text("Portfolio", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }

        }
        Spacer(modifier = Modifier.width(if (isNotCompact) 30.dp else 10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource("github.png"),
                contentDescription = null,
                modifier = Modifier.size(30.dp).clickable {
                    openUrl("https://github.com/Emami-114")
                },
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surface)
            )
            Spacer(modifier = Modifier.width(if (isNotCompact) 20.dp else 10.dp))

            Image(
                painterResource("twitter.png"),
                contentDescription = null,
                modifier = Modifier.size(30.dp).clickable {
                    openUrl("https://github.com/Emami-114")
                },
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surface)
            )
            Spacer(modifier = Modifier.width(if (isNotCompact) 20.dp else 10.dp))

            Image(
                painterResource("linkind.png"),
                contentDescription = null,
                modifier = Modifier.size(30.dp).clickable {
                    openUrl("https://github.com/Emami-114")
                },
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surface)
            )
        }


    }


}