package com.example

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.color

interface Modifier {
    companion object : Modifier
}

fun Modifier.styleModifier(styles: (StyleScope.() -> Unit)) = this

fun Modifier.color(color: CSSColorValue) = styleModifier {
    color(color)
}