package com.example.loinandregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loinandregister.ui.theme.LoinandRegisterTheme
import com.example.loinandregister.view.LoginPage
import com.example.loinandregister.view.RegisterPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoinandRegisterTheme {
                navigatePage()

                }
            }
        }


}
@Composable
fun navigatePage() {

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="login_Page" ,
        builder = {
        composable("login_Page" , content = { LoginPage(navController = navController)}) //LoginPage de el fun ell f Login File
        composable("register_Page" , content = { RegisterPage(navController = navController) }) //
    })
}


