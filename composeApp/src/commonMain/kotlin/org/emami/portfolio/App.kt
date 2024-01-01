package org.emami.portfolio

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.emami.portfolio.screen.AboutMe
import org.emami.portfolio.screen.Footer
import org.emami.portfolio.screen.MySkills
import org.emami.portfolio.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun App() = AppTheme {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(modifier = Modifier.animateContentSize()) {
        val scope = this
        val maxWidth = scope.maxWidth
        val isNotCompact = maxWidth > 750.dp
        Column(
            modifier = Modifier.fillMaxSize()

                .verticalScroll(scrollState).draggable(orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        coroutineScope.launch {
                            scrollState.scrollBy(-delta)
                        }
                    }),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(
                modifier = Modifier.padding(if (isNotCompact) 20.dp else 50.dp)
                    .windowInsetsPadding(WindowInsets.safeDrawing),
            ) {
                AboutMe(maxWidth, isNotCompact)
                Spacer(modifier = Modifier.height(if (isNotCompact) 200.dp else 100.dp))
                MySkills(maxWidth = maxWidth, isNotCompact)

                Spacer(modifier = Modifier.height(if (isNotCompact) 200.dp else 100.dp))

                MyPortfolio(isNotCompact, scrollState)
            }

            Spacer(modifier = Modifier.height(50.dp))
            Footer(isNotCompact)

        }


    }
}

@Composable
fun MyPortfolio(isNotCompact: Boolean, scrollState: ScrollState) {
    Text(
        text = "My Portfolio",
        fontSize = if (isNotCompact) 70.sp else 50.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color.White.copy(alpha = 0.6f),
        modifier = Modifier.fillMaxWidth()
    )
    if (isNotCompact) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(50.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                MyPortfolioItem(
                    title = "Abschluss Projekt iOS",
                    painterResource = "biarfood-gift.gif",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "swift.png", "api.png", "firebase.png", "iOS.png"
                    ),
                    linkTitle = "Github",
                    linkUrl = "https://github.com/Emami-114/BiarFoodiphone"
                )
                MyPortfolioItem(
                    title = "Abschluss Projekt MacOS",
                    painterResource = "biarfoodMac-Gift.gif",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "swift.png", "api.png", "firebase.png"
                    ),
                    linkTitle = "Github",
                    linkUrl = "https://github.com/Emami-114/BiarFoodMac"
                )
                MyPortfolioItem(
                    title = "Einbürgerungtest",
                    painterResource = "lebenInDeutschland.gif",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "android.png", "api.png", "kotlin.png"
                    ),
                    linkTitle = "Github",
                    linkUrl = "https://github.com/Emami-114/lebenInDeutschland"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(50.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                MyPortfolioItem(
                    title = "Learn App",
                    painterResource = "learnApp.gif",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "android.png", "api.png", "firebase.png", "kotlin.png"
                    ),
                    linkTitle = "Github",
                    linkUrl = "https://github.com/Emami-114/Abschluss_Projekt_LearnApp_Android-Modul"
                )
                MyPortfolioItem(
                    title = "Movie App",
                    painterResource = "Movie_gift.gif",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "android.png", "api.png", "kotlin.png"
                    ),
                    linkTitle = "Github",
                    linkUrl = "https://github.com/Emami-114/tmdb_movie_app_api"
                )
                MyPortfolioItem(
                    title = "Delivery App UI/Design",
                    painterResource = "figma-food.png",
                    modifier = Modifier.weight(1f),
                    listIcon = listOf(
                        "figma.png"
                    ),
                    linkTitle = "Behance",
                    linkUrl = "https://www.behance.net/gallery/158444109/Lebensmittel-Lieferservice-Grocery-Delivery-App"
                )
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical =  50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MyPortfolioItem(
                title = "Abschluss Projekt iOS",
                painterResource = "biarfood-gift.gif",
                modifier = Modifier,
                listIcon = listOf(
                    "swift.png", "api.png", "firebase.png", "iOS.png"
                ),
                linkTitle = "Github",
                linkUrl = "https://github.com/Emami-114/BiarFoodiphone"
            )
            MyPortfolioItem(
                title = "Abschluss Projekt MacOS",
                painterResource = "biarfoodMac-Gift.gif",
                modifier = Modifier,
                listIcon = listOf(
                    "swift.png", "api.png", "firebase.png"
                ),
                linkTitle = "Github",
                linkUrl = "https://github.com/Emami-114/BiarFoodMac"
            )
            MyPortfolioItem(
                title = "Einbürgerungtest",
                painterResource = "lebenInDeutschland.gif",
                modifier = Modifier,
                listIcon = listOf(
                    "android.png", "api.png", "kotlin.png"
                ),
                linkTitle = "Github",
                linkUrl = "https://github.com/Emami-114/lebenInDeutschland"
            )
            MyPortfolioItem(
                title = "Learn App",
                painterResource = "learnApp.gif",
                modifier = Modifier,
                listIcon = listOf(
                    "android.png", "api.png", "firebase.png", "kotlin.png"
                ),
                linkTitle = "Github",
                linkUrl = "https://github.com/Emami-114/Abschluss_Projekt_LearnApp_Android-Modul"
            )
            MyPortfolioItem(
                title = "Movie App",
                painterResource = "Movie_gift.gif",
                modifier = Modifier,
                listIcon = listOf(
                    "android.png", "api.png", "kotlin.png"
                ),
                linkTitle = "Github",
                linkUrl = "https://github.com/Emami-114/tmdb_movie_app_api"
            )
            MyPortfolioItem(
                title = "Delivery App UI/Design",
                painterResource = "figma-food.png",
                modifier = Modifier,
                listIcon = listOf(
                    "figma.png"
                ),
                linkTitle = "Behance",
                linkUrl = "https://www.behance.net/gallery/158444109/Lebensmittel-Lieferservice-Grocery-Delivery-App"
            )

        }
    }
}

@Composable
fun MyPortfolioItem(
    title: String,
    painterResource: String,
    modifier: Modifier = Modifier,
    linkTitle: String? = null,
    linkUrl: String? = null,
    listIcon: List<String>? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovering = interactionSource.collectIsHoveredAsState()
    Column(
        modifier = modifier.clip(RoundedCornerShape(20.dp))
            .background(
                if (isHovering.value) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surfaceVariant.copy(
                    alpha = 0.8f
                )
            )
            .border(
                width = 2.dp,
                color = if (isHovering.value) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)
            .hoverable(interactionSource, enabled = true),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(painterResource),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.clip(RoundedCornerShape(20.dp)).fillMaxWidth()
        )
        Text(text = title, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            listIcon?.forEach {
                Image(
                    painterResource(it), contentDescription = null, modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(color = Color.Gray)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        if (linkTitle != null) {
            TextButton(
                onClick = {
                    openUrl(linkUrl)
                }, shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(),
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.surface),
                modifier = Modifier,
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                Text(text = linkTitle)
            }
        }

    }

}


internal expect fun openUrl(url: String?)