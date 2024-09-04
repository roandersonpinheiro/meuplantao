package com.meuplantao.util.extensions

import com.meuplantao.util.DateFormatHelper.getFormattedDate
import androidx.compose.ui.graphics.Color

fun Long?.toStringFormat(): String {
    if (this == null) return ""
    return getFormattedDate(this, "dd MMM yyyy, HH:mm")
}


fun String.toColorOrNull(): Color? {
    return try {
        if (this.matches(Patterns.color)) {
            val colorInt = this.removePrefix("#").toLong(16)
            Color(
                red = ((colorInt shr 16) and 0xFF) / 255f,
                green = ((colorInt shr 8) and 0xFF) / 255f,
                blue = (colorInt and 0xFF) / 255f
            )
        } else {
            null
        }
    } catch (_: NumberFormatException) {
        null
    }
}

fun String.toColor(fallback: Color): Color = toColorOrNull() ?: fallback

fun Color.contrastColor(): Color {
    val luma = (0.299 * red) + (0.587 * green) + (0.114 * blue)

    return if (luma > 0.6) {
        Color.Black
    } else {
        Color.White
    }
}

object Patterns {
    val color = "#[0-9a-fA-F]{6}".toRegex()
}
