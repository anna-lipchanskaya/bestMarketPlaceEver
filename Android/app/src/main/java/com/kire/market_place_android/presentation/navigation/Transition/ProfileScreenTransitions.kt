package com.kire.market_place_android.presentation.navigation.Transition

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

import androidx.navigation.NavBackStackEntry
import com.kire.market_place_android.presentation.destinations.DeliveriesScreenDestination
import com.kire.market_place_android.presentation.destinations.FavouritesScreenDestination
import com.kire.market_place_android.presentation.destinations.ShoppingScreenDestination

import com.ramcosta.composedestinations.spec.DestinationStyle
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.ramcosta.composedestinations.utils.route

/**
 * By Michael Gontarev (KiREHwYE)*/
object ProfileScreenTransitions : DestinationStyle.Animated {

    private val destinationsOnLeft: List<DirectionDestinationSpec> = listOf(
       ShoppingScreenDestination, FavouritesScreenDestination
    )

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.enterTransition(): EnterTransition {
        return if (destinationsOnLeft.contains(initialState.route()))
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                    )+ fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
                else
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                    ) + fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.exitTransition(): ExitTransition {
        return if (destinationsOnLeft.contains(targetState.route()))
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            )+ fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
        else
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterTransition(): EnterTransition {
        return if (destinationsOnLeft.contains(initialState.route()))
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            )+ fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
        else
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitTransition(): ExitTransition {
        return if (destinationsOnLeft.contains(targetState.route()))
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            )+ fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
        else
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }
}