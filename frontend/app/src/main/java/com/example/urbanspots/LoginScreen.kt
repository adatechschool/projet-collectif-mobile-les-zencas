package com.example.urbanspots

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.urbanspots.components.CButton
import com.example.urbanspots.components.CTextField
import com.example.urbanspots.components.DontHaveAccountRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController
) {

    // we can copy and paste and do changes for signup screen
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(modifier =  Modifier.fillMaxSize()){


            /// Content

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {


                // Logo
                Image(painter = painterResource(id = R.drawable.logo_black),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )

                Text(text = "Sign In",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black
                    ),
                    modifier = Modifier.align(Alignment.Start)
                    )

                Text("Sign In now to begin your exploration.",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                    )


                // Text Field
                CTextField(hint = "Email Address", value = "" )

                CTextField(hint = "Password", value = "" )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(text = "Sign In")

                DontHaveAccountRow(
                    onSignupTap = {
                        navController.navigate("signup")
                    }
                )

            }

        }

    }

}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}