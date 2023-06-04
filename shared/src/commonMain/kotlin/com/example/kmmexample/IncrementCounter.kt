package com.example.kmmexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IncrementCounter() {

    Box(modifier = Modifier.fillMaxSize()){
        val programmingLanguageList = mutableListOf(
            "Kotlin" , "Swift" , "Java" , "Objective C" ,
            "Python" , "C-Sharp" , "Dot Net" , "Javascript" ,
            "Perl" , "C" , "Rust" , "Ruby on Rails" , "PHP" ,
            "Go"
        )
        LazyColumn {
            items(programmingLanguageList.size){ index ->
                Box(modifier = Modifier.fillMaxWidth().padding(24.dp).background(Color.Black)){
                    Text(text = programmingLanguageList[index] ,
                        fontSize = 20.sp ,
                        color = Color.White ,
                        modifier = Modifier.fillMaxWidth().padding(24.dp))
                }
            }
        }
    }
}
