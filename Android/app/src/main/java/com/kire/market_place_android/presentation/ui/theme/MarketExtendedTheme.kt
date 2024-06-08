package com.kire.market_place_android.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * By Aleksey Timko (de4ltt)
 * By Michael Gontarev (KiREHwYe)*/

val LocalExtendedColors = staticCompositionLocalOf {
    MarketExtendedColors(
        redAccent  = Color(0xFFB20000),
        black10 = Color(0, 0, 0, 25),
        greenPrice = Color(8, 78, 0, 255),
        profileBar = Color(0xFFEDEDED),
        deliveredBar = Color(0, 175, 28, 255),
        deniedBar = Color(137, 0, 0, 255),
        onTheWayBar = Color(115, 115, 115, 255),
        readyBar = Color(145, 214, 0, 255),
        redAccentSoft = Color(0x48B20000)
    )
}


@Composable
fun MarketExtendedTheme(
    content: @Composable () -> Unit
) {
    val extendedColors = MarketExtendedColors(
        redAccent = Color(0xFFB20000),
        black10 = Color(0, 0, 0, 25),
        greenPrice = Color(8, 78, 0, 255),
        profileBar = Color(0xFFEDEDED),
        deliveredBar = Color(0, 175, 28, 255),
        deniedBar = Color(137, 0, 0, 255),
        onTheWayBar = Color(115, 115, 115, 255),
        readyBar = Color(145, 214, 0, 255),
        redAccentSoft = Color(0x48B20000)
    )
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        Market_Place_AndroidTheme(
            /* colors = ..., typography = ..., shapes = ... */
            content = content
        )
    }
}

// Use with eg. ExtendedTheme.colors.tertiary
object ExtendedTheme {
    val colors: MarketExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}
