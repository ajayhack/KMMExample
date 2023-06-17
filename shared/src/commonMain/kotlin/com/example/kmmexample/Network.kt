package com.example.kmmexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Composable
fun NetworkCallAndShowResponse() {
    Box(modifier = Modifier.fillMaxSize()
        .background(color = Color.White)){
            val scope = rememberCoroutineScope()
            var modal by remember { mutableStateOf(DogImage()) }
            LaunchedEffect(true) {
                scope.launch {
                    modal = try {
                        callDogImageAPI()
                    } catch (e: Exception) {
                        DogImage()
                    }
                }
            }
           ShowResponse(modal)
    }
}

@Composable
fun ShowResponse(modal: DogImage) {
    Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center) {
        Text(text = modal.message?.get(0) ?: "")
    }
}

private val client = HttpClient(){
    install(ContentNegotiation){
        json(Json {
            ignoreUnknownKeys = true
            useAlternativeNames = true
        })
    }
}

suspend fun callDogImageAPI(): DogImage {
    val response : DogImage =  client.get("https://dog.ceo/api/breed/hound/images/random/3").body()
    return response
}

@Serializable
data class DogImage(val message : MutableList<String>? = null ,
                            val status : String? = null)

