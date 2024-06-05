package com.kire.market_place_android.presentation.navigation.Transition

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

import androidx.navigation.NavBackStackEntry
import com.kire.market_place_android.presentation.destinations.ShoppingCartScreenDestination

import com.ramcosta.composedestinations.spec.DestinationStyle
import com.ramcosta.composedestinations.utils.route

/**
 * By Michael Gontarev (KiREHwYE)*/
object ItemAddToCartMenuScreenTransitions  : DestinationStyle.Animated {

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.enterTransition(): EnterTransition {
        return if (initialState.route() == ShoppingCartScreenDestination)
            EnterTransition.None
        else
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up, animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)) +
                    fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.exitTransition(): ExitTransition {
        return if (targetState.route() == ShoppingCartScreenDestination)
            fadeOut(animationSpec = tween(2000, easing = LinearOutSlowInEasing))
        else
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down, animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)) +
                    fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterTransition(): EnterTransition {
        return if (initialState.route() == ShoppingCartScreenDestination)
            EnterTransition.None
        else
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up, animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)) +
                    fadeIn(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitTransition(): ExitTransition {
        return if (targetState.route() == ShoppingCartScreenDestination)
            fadeOut(animationSpec = tween(2000, easing = LinearOutSlowInEasing))
        else
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down, animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)) +
                    fadeOut(animationSpec = tween(300, easing = LinearOutSlowInEasing))
    }
}