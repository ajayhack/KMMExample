package com.example.kmmexample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform