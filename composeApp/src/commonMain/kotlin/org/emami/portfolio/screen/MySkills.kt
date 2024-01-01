package org.emami.portfolio.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.jetbrains.compose.resources.painterResource

@Composable
fun MySkills(maxWidth: Dp, isNotCompact: Boolean) {
    Column(modifier = Modifier.padding(if (isNotCompact) 50.dp else 10.dp)) {
        Text(
            text = "My Skills",
            fontSize = if (isNotCompact) 70.sp else 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White.copy(alpha = 0.6f),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            SkillsItem(
                modifier = Modifier.weight(1f),
                isNotCompact,
                title = "UX/UI Design",
                painterResource = "figma-icon.png"
            )
            SkillsItem(
                modifier = Modifier.weight(1f), isNotCompact,
                title = "kotlin-icon.png",
                painterResource = "kotlin-icon.png"
            )

            SkillsItem(
                modifier = Modifier.weight(1f),
                isNotCompact,
                title = "iOS with Swift",
                painterResource = "swift-icon.png"
            )
        }
    }
}

@Composable
fun SkillsItem(
    modifier: Modifier = Modifier,
    isNotCompact: Boolean,
    title: String,
    painterResource: String
) {
    Box(modifier = modifier.clip(RoundedCornerShape(15.dp))
        .clickable { }
        .background(MaterialTheme.colorScheme.surfaceVariant).padding(10.dp)
        .size(if (isNotCompact) 80.dp else 50.dp),
        contentAlignment = if (isNotCompact) Alignment.CenterStart else Alignment.Center) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isNotCompact) {
                Image(
                    painter = painterResource(painterResource),
                    contentDescription = null,
                    modifier = Modifier.size(if (isNotCompact) 70.dp else 50.dp)
                )
                Text(text = title, fontSize = 25.sp)
            } else {
                Image(
                    painter = painterResource(painterResource),
                    contentDescription = null,
                    modifier = Modifier.size(if (isNotCompact) 80.dp else 50.dp)
                )
            }
        }
    }
}