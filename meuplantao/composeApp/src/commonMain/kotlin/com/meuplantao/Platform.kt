package com.meuplantao

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform