package com.mustafa.cryptokotlinapp.composables

/*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mustafa.cryptokotlinapp.model.CryptoModel
import com.mustafa.cryptokotlinapp.viewmodel.CryptoListViewModel
@Composable
fun CryptoRow(navController: NavController,cryoto:CryptoModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.secondary)
        .clickable {
            navController.navigate("crypto_detail_screen/${cryoto.currency}/${cryoto.price}")
        }

        ) {
            Text(text = cryoto.currency.toString(),
             style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        Text(text = cryoto.price.toString(),
                style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(2.dp),
            color = MaterialTheme.colors.primaryVariant
        )

    }
}

@Composable
fun CryptoListView(cryptos:List<CryptoModel>,navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
        ,contentPadding = PaddingValues(5.dp)){
        items(cryptos){ crypto ->
            CryptoRow(navController = navController, cryoto = crypto)
        }
    }
}


@Composable
fun CryptoList(navController: NavController,viewModel: CryptoListViewModel = hiltViewModel()) {
    val crytolist by remember { viewModel.cryptoList}
    val error by remember {viewModel.error}
    val isloading by remember {viewModel.isLoading}

    CryptoListView(cryptos = crytolist, navController = navController)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        if (isloading){
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (error.isNotEmpty()){
                RetryView(error = error) {
                    viewModel.getDataList()
                }
        }
    }

}

@Composable
fun RetryView(
    error:String,
    onRetry:()->Unit
) {
    Column() {
        Text(text = error, color = Color.Red, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { onRetry },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
            Text(text = "Retry",)
        }
    }
    
}
*/