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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.inspirecoding.clinicapp.commons.extensions.convertBase64ToBitmap
import com.inspirecoding.clinicapp.commons.extensions.rememberFlowWithLifecycle
import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import com.inspirecoding.clinicapp.core.redirect.HomeRedirect
import com.inspirecoding.clinicapp.domain.models.toggle.FeatureToggleLoginModel
import com.inspirecoding.clinicapp.ds.R
import com.inspirecoding.clinicapp.ds.components.logo.AnimatedClinicAppLogo
import com.inspirecoding.clinicapp.ds.components.text.InputCustomField
import com.inspirecoding.clinicapp.ds.theme.color.DarkBlue
import com.inspirecoding.clinicapp.ds.theme.color.White
import com.inspirecoding.clinicapp.features.login.action.LoginAction
import com.inspirecoding.clinicapp.features.login.state.LoginState
import com.inspirecoding.clinicapp.features.login.viewmodel.LoginViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.inject

@Composable
fun LoginScreen(viewModel: LoginViewModel = getViewModel()) {

    val viewState by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = LoginState.Loading)

    Login(state = viewState) { action ->
        viewModel.submitAction(action)
    }
}

@Composable
fun Login(
    state: LoginState,
    action: (LoginAction) -> Unit
) {

    val context = LocalContext.current

    action(LoginAction.GetSharedPreferencesNavigation(context = context))
    action(LoginAction.GetLoginScreenConfig)

    when (state) {
        is LoginState.Loading -> AnimatedClinicAppLogo()
        is LoginState.GetLoginScreenConfig -> LoginMainScreen(screenModelDomain = state.screenModelDomain ?: ScreenModelDomain())
    }

}

@Composable
fun LoginMainScreen(screenModelDomain: ScreenModelDomain) {

    val context = LocalContext.current
    val redirectHome: HomeRedirect by inject()
    val email = remember { mutableStateOf("") }
    val secret = remember { mutableStateOf("") }
    var secretVisibility = remember { mutableStateOf(false) }
    val rememberMe = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(screenModelDomain.columnModelDomain.padding.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = screenModelDomain.columnModelDomain.horizontalAlignment,
        verticalArrangement = screenModelDomain.columnModelDomain.verticalArrangement
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(
                        screenModelDomain.imageModelDomain.value.convertBase64ToBitmap()
                            ?: R.drawable.ic_clinicapp_logo
                    )
                    .apply(block = fun ImageRequest.Builder.() {
                        error(R.drawable.ic_clinicapp_logo)
                        placeholder(R.drawable.ic_clinicapp_logo)
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenModelDomain.imageModelDomain.height.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(screenModelDomain.imageModelDomain.spacer.dp))

        InputCustomField(
            text = email,
            label = screenModelDomain.fieldsModelDomain.firstLabel,
            onTextChange = {},
        )

        Spacer(modifier = Modifier.height(screenModelDomain.fieldsModelDomain.spacer.dp))

        InputCustomField(
            text = secret,
            label = screenModelDomain.fieldsModelDomain.secondLabel,
            onTextChange = {},
        )

        Spacer(modifier = Modifier.height(screenModelDomain.fieldsModelDomain.spacer.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = screenModelDomain.rowModelDomain.horizontalArrangement,
            verticalAlignment = screenModelDomain.rowModelDomain.verticalAlignment
        ) {
            Row(verticalAlignment = screenModelDomain.rowModelDomain.verticalAlignment) {
                Checkbox(
                    checked = rememberMe.value,
                    onCheckedChange = { rememberMe.value = it }
                )
                Text(screenModelDomain.rowModelDomain.checkboxLabel)
            }
            Text(
                text = screenModelDomain.rowModelDomain.firstLabel,
                color = DarkBlue,
                modifier = Modifier.clickable {
                    Toast.makeText(context, screenModelDomain.rowModelDomain.firstLabel, Toast.LENGTH_SHORT).show()
                }
            )
        }
        Spacer(modifier = Modifier.height(screenModelDomain.rowModelDomain.spacer.dp))
        Button(
            onClick = {
                redirectHome.redirectToHome(context)
                Toast.makeText(context, screenModelDomain.buttonModelDomain.label, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                containerColor = DarkBlue,
                contentColor = White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Text(screenModelDomain.buttonModelDomain.label, color = Color.White)
        }
        Spacer(modifier = Modifier.height(screenModelDomain.buttonModelDomain.spacer.dp))
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(screenModelDomain.dividerModelDomain.spacer.dp))
        Row(verticalAlignment = screenModelDomain.bottomModelDomain.verticalAlignment) {
            Text(screenModelDomain.bottomModelDomain.firstLabel)
            Spacer(modifier = Modifier.width(screenModelDomain.dividerModelDomain.spacer.dp))
            Text(
                text = screenModelDomain.bottomModelDomain.secondLabel,
                color = DarkBlue,
                modifier = Modifier.clickable {
                    Toast.makeText(context, screenModelDomain.bottomModelDomain.secondLabel, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}