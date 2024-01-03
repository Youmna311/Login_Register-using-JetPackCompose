package com.example.loinandregister.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loinandregister.R
import com.example.loinandregister.ui.theme.Purple200


@Composable
fun LoginPage(navController: NavController){

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White) , contentAlignment = Alignment.Center)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center , modifier = Modifier.fillMaxSize())
        {
            // el column da el view elly h7ot feh image w zabt el alignment bta3ha mn el column attributes
            Box(modifier = Modifier.background(color = Color.White), contentAlignment = Alignment.TopCenter){

                // gwa el box da h7ot rl image

                Image(modifier= Modifier
                    .width(400.dp)
                    .height(350.dp) ,
                    painter =  painterResource(R.drawable.login),
                    contentDescription= "Login Image" ,
                    contentScale = ContentScale.Fit
                )
            }
            
            Spacer(modifier = Modifier.padding(20.dp)) // space ben el image w el ba2y

            Scaffold(modifier = Modifier.fillMaxSize() , scaffoldState = scaffoldState) {
                Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(10.dp)) {
                    Text(text = "Sign In" , fontSize = 24.sp , fontWeight = FontWeight.Bold , color = Color.Black)
                    Spacer(modifier = Modifier.padding(20.dp)) // space ben el signin title w el ba2y
                    Column(horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
                        OutlinedTextField(value = emailVal.value, onValueChange = {
                            emailVal.value=it //lma el value bta3 em emial hsalo change , ezn it de hya el new value f b assign  it ll el emailVal

                        } ,
                            label = { Text(text = "Email Address" , color = Color.Black)} , // label de ha label el edittext
                            placeholder = { Text(text = "Email Address" , color = Color.Black)} , //placeholder de hya el hint f el edit text
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f), colors= TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black , textColor = Color.Black), // de en elly hktbo ykon black
                            )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = {
                                passwordVal.value =
                                    it //lma el value bta3 em emial hsalo change , ezn it de hya el new value f b assign  it ll el emailVal

                            },
                            trailingIcon = {
                                IconButton(onClick = {
                                passwordVisibility.value= !passwordVisibility.value }) {
                                    Icon(painter = painterResource(id=R.drawable.ic_baseline_remove_red_eye_24), contentDescription ="Password" ,
                                    tint = if (passwordVisibility.value) Purple200 else Color.Gray)

                                }
                            },
                            visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                            label = {
                                Text(
                                    text = "Password",
                                    color = Color.Black
                                )
                            }, // label de ha label el edittext
                            placeholder = {
                                Text(
                                    text = "Password",
                                    color = Color.Black
                                )
                            }, //placeholder de hya el hint f el edit text
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black) // de en elly hktbo ykon black
                        )
                        Spacer(modifier = Modifier.padding(20.dp)) // space ben el edittexts title w el ba2y
                        Button(onClick = {
                                         when {
                                             emailVal.value.isEmpty() -> {
                                                 Toast.makeText(
                                                     context,
                                                     "Please Fill The Email Address",
                                                     Toast.LENGTH_SHORT
                                                 ).show()
                                             }
                                             passwordVal.value.isEmpty() -> {
                                                 Toast.makeText(
                                                     context,
                                                     "Please Fill The Password ",
                                                     Toast.LENGTH_SHORT
                                                 ).show()

                                             }
                                             else ->  Toast.makeText(
                                                 context,
                                                 "Logged Successfully ",
                                                 Toast.LENGTH_SHORT
                                             ).show()

                                         } } , modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.White) , ) {
                            Text(text = "Sign In", fontSize = 22.sp , color = Color.Black) }
                        Spacer(modifier = Modifier.padding(20.dp)) // space ben el signin button w el crate account

                        Text(
                            text = "Create An Account?",
                            color = Color.Black,
                            fontSize = 22.sp,
                            modifier = Modifier.clickable {
                                navController.navigate("register_Page")
                            })

                        Spacer(modifier = Modifier.padding(20.dp))




                    }





                }

            }



        }

        //modifier.fillmaxsize :  يعني خليت البوكس ياخد الصفحه كامله ويخلي الباك جراوند ابيض

        
    }
}