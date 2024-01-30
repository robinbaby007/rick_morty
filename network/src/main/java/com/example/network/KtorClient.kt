package com.example.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

class KtorClient {
    private val client = HttpClient(OkHttp) {
        
    }
}