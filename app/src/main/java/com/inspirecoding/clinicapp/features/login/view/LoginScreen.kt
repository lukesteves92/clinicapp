package com.inspirecoding.clinicapp.features.login.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.inspirecoding.clinicapp.R
import com.inspirecoding.clinicapp.ui.components.InputCustomField
import com.inspirecoding.clinicapp.ui.theme.color.DarkBlue
import com.inspirecoding.clinicapp.ui.theme.color.White

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val secret = remember { mutableStateOf("") }
    var secretVisibility = remember { mutableStateOf(false) }
    val rememberMe = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier.size(300.dp),
            painter = rememberAsyncImagePainter(R.drawable.ic_clinicapp_logo),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(16.dp))

        InputCustomField(
            text = email,
            label = stringResource(R.string.clinicapp_email_login_label),
            onTextChange = {},
        )

        Spacer(modifier = Modifier.height(16.dp))

        InputCustomField(
            text = secret,
            label = stringResource(R.string.clinicapp_secret_login_label),
            onTextChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe.value,
                    onCheckedChange = { rememberMe.value = it }
                )
                Text(stringResource(R.string.clinicapp_remember_me_login_label))
            }
            Text(
                text = stringResource(R.string.clinicapp_forget_secret_login_label),
                color = DarkBlue,
                modifier = Modifier.clickable {
                    // Lógica para redefinir senha
                    Toast.makeText(context, "Esqueceu sua senha?", Toast.LENGTH_SHORT).show()
                }
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                // Lógica de login
                Toast.makeText(context, "Entrar", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                containerColor = DarkBlue,
                contentColor = White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Text("ENTRAR", color = Color.White)
        }
        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                // Lógica de login com Facebook
                Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Text("CONTINUAR COM O FACEBOOK", color = Color.White)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Não tem uma conta?")
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.clinicapp_register_login_label),
                color = DarkBlue,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Inscreva-se", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}