package com.meuplantao.util.extensions

import com.meuplantao.util.DateFormatHelper.getFormattedDate
import androidx.compose.ui.graphics.Color

fun Long?.toFormattedString(pattern: String = "dd MMM yyyy, HH:mm"): String {
    return this?.let { getFormattedDate(it, pattern) } ?: ""
}

fun String.toColorOrNull(): Color? {
    return try {
        if (Patterns.HEX_COLOR.matches(this)) {
            val colorInt = this.removePrefix("#").toLong(16)
            Color(
                red = ((colorInt shr 16) and 0xFF) / 255f,
                green = ((colorInt shr 8) and 0xFF) / 255f,
                blue = (colorInt and 0xFF) / 255f
            )
        } else {
            null
        }
    } catch (e: NumberFormatException) {
        null
    }
}

fun String.toColor(fallback: Color = Color.Unspecified): Color {
    return toColorOrNull() ?: fallback
}

fun Color.contrastColor(): Color {
    val luminance = 0.299 * red + 0.587 * green + 0.114 * blue
    return if (luminance > 0.6) Color.Black else Color.White
}

object Patterns {
    val HEX_COLOR = Regex("^#[0-9a-fA-F]{6}$")
}
