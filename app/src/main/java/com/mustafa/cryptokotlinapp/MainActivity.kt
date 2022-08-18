package com.mustafa.cryptokotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mustafa.cryptokotlinapp.ui.theme.CryptoKotlinAppTheme
import com.mustafa.cryptokotlinapp.view.CryptoDetailScreen
import com.mustafa.cryptokotlinapp.view.CryptoListScreen
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Type

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoKotlinAppTheme {
               val navController = rememberNavController()
                NavHost(navController = navController , startDestination = "crypto_list_screen"){
                    composable("crypto_list_screen"){
                        // Sayfayı yazılacak
                        CryptoListScreen(navController = navController)
                    }

                    composable("crypto_detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoId"){
                            type = NavType.StringType
                        },
                        navArgument("cryptoPrice"){
                            type = NavType.StringType
                        }
                    )){

                        val cryptoId = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cryptoPrice")
                        }

                        CryptoDetailScreen(
                            crytoId = cryptoId ?: "",
                            cryptoPrice = cryptoPrice ?: ""
                            , navController = navController )
                    }

                }//navHost bitiş
            }
        }
    }
}

