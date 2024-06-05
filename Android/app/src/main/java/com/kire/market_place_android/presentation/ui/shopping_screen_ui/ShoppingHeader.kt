package com.kire.market_place_android.presentation.ui.shopping_screen_ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.kire.market_place_android.presentation.ui.theme.ExtendedTheme

import com.kire.test.R

/**
 * By Michael Gontarev (KiREHwYE)*/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingHeader(
    curPickUpPoint: String = "г. Краснодар, ул. Ставропольская, д. 149, эт. 1, кб. 133",
    @DrawableRes leadingIcon: Int,
    paddingValuesTopDp: Dp = 84.dp,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(top = paddingValuesTopDp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                tint = ExtendedTheme.colors.redAccent,
                modifier = Modifier
                    .size(34.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 4.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(id = R.string.pick_up_point),
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = Color.DarkGray
                )

                Text(
                    text = curPickUpPoint,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .basicMarquee(
                            animationMode = MarqueeAnimationMode.Immediately,
                            delayMillis = 0
                        )
                )
            }
        }
    }

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(top = paddingValuesTopDp, bottom = 12.dp),
//        horizontalAlignment = Alignment.Start,
//        verticalArrangement = Arrangement.Bottom
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            horizontalArrangement = Arrangement.spacedBy(4.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Icon(
//                painter = painterResource(id = R.drawable.location),
//                contentDescription = "Location Icon",
//                tint = ExtendedTheme.colors.redAccent
//            )
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//                verticalArrangement = Arrangement.spacedBy(2.dp),
//                horizontalAlignment = Alignment.Start
//            ) {
//                Text(
//                    text = stringResource(id = R.string.pick_up_point),
//                    fontWeight = FontWeight.Light,
//                    fontSize = 15.sp,
//                    color = Color.DarkGray
//                )
//
//                Text(
//                    text = curPickUpPoint,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 14.sp,
//                    color = Color.Black,
//                    modifier = Modifier
//                        .basicMarquee(
//                            animationMode = MarqueeAnimationMode.Immediately,
//                            delayMillis = 0
//                        )
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        ShoppingScreenSearchBar(
//            curSearchRequest = null,
//            curFilterRequest = FilterRequest(null, null, null)
//        )
//    }
}