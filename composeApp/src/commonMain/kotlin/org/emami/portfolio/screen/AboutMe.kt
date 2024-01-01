package org.emami.portfolio.screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import org.emami.portfolio.openUrl
import org.jetbrains.compose.resources.painterResource

@Composable
fun AboutMe(maxWidth: Dp, isNotCompact: Boolean) {
    val imageInterActionSource = remember { MutableInteractionSource() }
    val imageHovering by imageInterActionSource.collectIsHoveredAsState()
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val infiniteTransition = rememberInfiniteTransition()
    val infinitTrans by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    if (!isNotCompact) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .hoverable(imageInterActionSource),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource("image2.png"),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.sizeIn(maxWidth = 500.dp).zIndex(1f)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier.sizeIn(maxWidth = 500.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth().height(30.dp).graphicsLayer {
                                if (!imageHovering) {
                                    translationX = infinitTrans
                                }
                            }
                                .background(Color.Red, shape = MaterialTheme.shapes.medium)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth().height(30.dp)
                                .graphicsLayer {
                                    if (!imageHovering) {
                                        translationX = -infinitTrans
                                    }
                                }
                                .background(Color.Red, shape = MaterialTheme.shapes.medium)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth().height(30.dp)
                                .graphicsLayer {
                                    if (!imageHovering) {
                                        translationX = infinitTrans - 20
                                    }
                                }
                                .background(Color.Red, shape = MaterialTheme.shapes.medium)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth().height(30.dp)
                                .graphicsLayer {
                                    if (!imageHovering) {
                                        translationX = infinitTrans - 30
                                    }
                                }
                                .background(Color.Red, shape = MaterialTheme.shapes.medium)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth().height(30.dp)
                                .graphicsLayer {
                                    if (!imageHovering) {
                                        translationX = -infinitTrans
                                    }
                                }
                                .background(Color.Red, shape = MaterialTheme.shapes.medium)
                        )
                        Box(modifier = Modifier.fillMaxWidth().height(30.dp)
                            .graphicsLayer {
                                if (!imageHovering) {
                                    translationX = infinitTrans
                                }
                            }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium))
                    }
                }
                Column {
                    Text(
                        text = "Hi! I'm",
                        fontSize = if (isNotCompact) 50.sp else 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                    Text(
                        text = "Abdul Emami",
                        fontSize = if (isNotCompact) 70.sp else 50.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "iOS and Android Developer",
                        fontSize = if (isNotCompact) 30.sp else 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    TextButton(onClick = {
                        openUrl("https://github.com/Emami-114")
                    }) {
                        Image(
                            painter = painterResource("github.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    TextButton(onClick = {
                        openUrl("linkedin.com/in/abdul-emami-4bb489251")
                    }) {
                        Image(
                            painter = painterResource("linkind.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    TextButton(onClick = {}) {
                        Image(
                            painter = painterResource("twitter.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    Spacer(modifier = Modifier.width(if (!isNotCompact) 5.dp else 30.dp))

                    OutlinedButton(
                        onClick = {},
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(text = "Resume", fontSize = 20.sp)
                    }
                }
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(
                        text = "Hi! I'm",
                        fontSize = if (isNotCompact) 50.sp else 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                    Text(
                        text = "Abdul Emami",
                        fontSize = if (isNotCompact) 70.sp else 50.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "iOS and Android Developer",
                        fontSize = if (isNotCompact) 30.sp else 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    TextButton(onClick = {
                        openUrl("https://github.com/Emami-114")
                    }) {
                        Image(
                            painter = painterResource("github.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    TextButton(onClick = {
                        openUrl("linkedin.com/in/abdul-emami-4bb489251")
                    }) {
                        Image(
                            painter = painterResource("linkind.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    TextButton(onClick = {}) {
                        Image(
                            painter = painterResource("twitter.png"),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                    Spacer(modifier = Modifier.width(30.dp))

                    OutlinedButton(
                        onClick = {},
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(text = "Resume", fontSize = 20.sp)

                    }

                }
            }
            Box(
                modifier = Modifier.weight(1f)
                    .hoverable(imageInterActionSource),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource("image2.png"),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.sizeIn(maxWidth = 500.dp).zIndex(1f)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.sizeIn(maxWidth = 500.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(30.dp).graphicsLayer {
                            if (!imageHovering) {
                                translationX = infinitTrans
                            }
                        }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth().height(30.dp)
                            .graphicsLayer {
                                if (!imageHovering) {
                                    translationX = -infinitTrans
                                }
                            }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth().height(30.dp)
                            .graphicsLayer {
                                if (!imageHovering) {
                                    translationX = infinitTrans - 20
                                }
                            }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth().height(30.dp)
                            .graphicsLayer {
                                if (!imageHovering) {
                                    translationX = infinitTrans - 30
                                }
                            }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth().height(30.dp)
                            .graphicsLayer {
                                if (!imageHovering) {
                                    translationX = -infinitTrans
                                }
                            }
                            .background(Color.Red, shape = MaterialTheme.shapes.medium)
                    )
                    Box(modifier = Modifier.fillMaxWidth().height(30.dp)
                        .graphicsLayer {
                            if (!imageHovering) {
                                translationX = infinitTrans
                            }
                        }
                        .background(Color.Red, shape = MaterialTheme.shapes.medium))
                }
            }
        }
    }
}

@Composable
fun iconButton() {
    Box(modifier = Modifier.size(50.dp)) {

    }
}