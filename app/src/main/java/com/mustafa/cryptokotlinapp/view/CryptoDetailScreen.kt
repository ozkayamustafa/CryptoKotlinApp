package com.mustafa.cryptokotlinapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mustafa.cryptokotlinapp.viewmodel.CryptoDetailViewModel

@Composable
fun CryptoDetailScreen(
    crytoId:String,
    cryptoPrice:String,
    navController: NavController,
    viewModel: CryptoDetailViewModel = hiltViewModel()
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.secondary)
        , contentAlignment = Alignment.Center){
        
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = crytoId,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = cryptoPrice,
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.h5
            )
        }
        
    }

}