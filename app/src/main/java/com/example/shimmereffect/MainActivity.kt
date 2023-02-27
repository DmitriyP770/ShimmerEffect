package com.example.shimmereffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shimmereffect.ui.theme.ShimmerEffectTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerEffectTheme {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = true ){
                    delay(10000)
                    isLoading = false
                }
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(20){
                        ShimmerListItem(
                            isLoading = isLoading ,
                            modifier = Modifier.padding(16.dp) ,
                            contentAfterLoading = {
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Home ,
                                        contentDescription = "Home",
                                        modifier = Modifier.size(100.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(text = "Long Text to show that our text" + "looking perfectly fine")
                                }
                            }
                        )
                    }
                }

            }
        }
    }
}

