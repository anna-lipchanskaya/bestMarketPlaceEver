package com.kire.market_place_android.presentation.ui.screen

import android.net.Uri

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kire.market_place_android.presentation.destinations.OrderScreenDestination
import com.kire.market_place_android.presentation.destinations.ShoppingScreenDestination

import com.kire.market_place_android.presentation.model.ProductItem
import com.kire.market_place_android.presentation.navigation.Transition.OrderScreenTransitions
import com.kire.market_place_android.presentation.navigation.util.AppDestinations
import com.kire.market_place_android.presentation.ui.cross_screen_ui.OnScrollListener
import com.kire.market_place_android.presentation.ui.cross_screen_ui.TopBar
import com.kire.market_place_android.presentation.ui.order_screen_ui.OrderFloatingButton
import com.kire.market_place_android.presentation.ui.order_screen_ui.OrderItem
import com.kire.test.R

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * By Michael Gontarev (KiREHwYE)*/
@Destination(style = OrderScreenTransitions::class)
@Composable
fun OrderScreen(
    navigator: DestinationsNavigator,
    shoppingCartItems: List<ProductItem> = listOf(
        ProductItem("Помидоры", "250.00", "кг","250.00", Uri.EMPTY, false, ""),
        ProductItem("Груши", "300.00","кг","250.00", Uri.EMPTY, true, ""),
        ProductItem("Помидоры", "250.00","кг","300.00", Uri.EMPTY, true, ""),
        ProductItem("Груши", "300.00","кг","250.00", Uri.EMPTY, false, ""),
        ProductItem("Помидоры", "250.00","кг","250.00", Uri.EMPTY, false, ""),
        ProductItem("Груши", "300.00","кг","250.00", Uri.EMPTY, true, "")
    ),
    paddingValues: PaddingValues = PaddingValues(start = 28.dp, end = 28.dp)
) {

    BackHandler {
        navigator.popBackStack()
        return@BackHandler
    }

    val listState = rememberLazyListState()

    val isShown = remember {
        mutableStateOf(true)
    }

    OnScrollListener(
        listState = listState,
        isShown = {
            isShown.value = it
        }
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(
            destination = AppDestinations.ManagerDestinations.ORDER,
            navigator = navigator
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f, fill = false),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            when(shoppingCartItems.size) {
                0 -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                text = stringResource(R.string.nothing_was_found),
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        }
                    )
                }
                else -> {

                    LazyColumn(
                        state = listState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        contentPadding = PaddingValues(bottom = 28.dp)
                    ) {

                        itemsIndexed(
                            shoppingCartItems,
                            key = null
                        ) { index, item ->

                            OrderItem(
                                name = item.itemName,
                                price = item.itemPrice,
                                amount = 3.0
                            )
                        }
                    }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 28.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        AnimatedVisibility(
            visible = isShown.value,
            enter =
            slideInVertically(
                initialOffsetY = {height -> -height},
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)),
            exit = slideOutVertically(
                targetOffsetY = {height -> height},
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing))
        ) {

            OrderFloatingButton(
                onClick = {
                    /*TODO*/
                }
            )
        }
    }
}