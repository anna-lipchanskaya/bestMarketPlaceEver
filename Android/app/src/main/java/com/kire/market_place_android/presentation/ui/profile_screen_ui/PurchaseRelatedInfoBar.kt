package com.kire.market_place_android.presentation.ui.profile_screen_ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

/**
 * By Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PurchaseRelatedInfoBar(
    title: String,
    sign: String,
    info: String,
    roundedCornerShape: RoundedCornerShape =
        RoundedCornerShape(
            topStart = 18.dp,
            topEnd = 18.dp,
            bottomEnd = 18.dp
        ),
    paddingValues: PaddingValues = PaddingValues(20.dp),
    onClick: () -> Unit = { }
) {

    val clickable: Boolean = title == stringResource(id = R.string.deliveries_title)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(roundedCornerShape)
            .background(ExtendedTheme.colors.profileBar)
            .padding(paddingValues)
            .pointerInput(Unit) {
                detectTapGestures {
                    if (clickable)
                        onClick()
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.Immediately,
                    delayMillis = 0
                )
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(sign)
                }
                withStyle(
                    style = SpanStyle(
                        color = ExtendedTheme.colors.redAccent,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(info)
                }
            },
            modifier = Modifier
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.Immediately,
                    delayMillis = 0
                )
        )
    }
}