package com.meuplantao.util.extensions

import com.meuplantao.util.DateFormatHelper.getFormattedDate
fun Long?.toStringFormat(): String {
    if (this == null) return ""
    return getFormattedDate(this, "dd MMM yyyy, HH:mm")
}