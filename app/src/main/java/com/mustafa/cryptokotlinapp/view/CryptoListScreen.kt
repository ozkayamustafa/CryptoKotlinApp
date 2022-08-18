package com.mustafa.cryptokotlinapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mustafa.cryptokotlinapp.viewmodel.CryptoListViewModel

@Composable
fun CryptoListScreen
            (
    navController: NavController,
    viewModel:CryptoListViewModel = hiltViewModel()
) {
    androidx.compose.material.Surface(
        color =  MaterialTheme.colors.secondary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = "Crypto App",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color= MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
                )
            Spacer(modifier = Modifier.height(10.dp))
            //Search
                SearchBar(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    hint = "SearcH.."
                ){
                    //viewModel.searchCryptoList(it)
                }
            Spacer(modifier = Modifier.height(10.dp))
            // List

        }


    }
    
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint:String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplay by remember {
        mutableStateOf( hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text, onValueChange ={
            text = it
            onSearch(it)
        },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .onFocusChanged {
                    isHintDisplay = it.isFocused != true && text.isEmpty()
                },
        )
        if (isHintDisplay){
            Text(text = hint, color = Color.LightGray,modifier = Modifier.padding(horizontal = 20.dp,12.dp))
        }
    }



}