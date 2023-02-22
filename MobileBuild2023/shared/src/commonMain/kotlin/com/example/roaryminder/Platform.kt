package com.example.roaryminder

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform