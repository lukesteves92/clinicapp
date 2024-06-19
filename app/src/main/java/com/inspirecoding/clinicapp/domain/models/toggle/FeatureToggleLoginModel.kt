package com.inspirecoding.clinicapp.domain.models.toggle

import com.google.gson.annotations.SerializedName
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT

data class FeatureToggleLoginModel(
    @SerializedName("login_screen_email_label")
    val loginScreenEmailLabel: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_facebook_button_text")
    val loginScreenFacebookButtonText: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_forgot_password_label")
    val loginScreenForgotPasswordLabel: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_login_button_text")
    val loginScreenLoginButtonText: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_logo_base64")
    val loginScreenLogoBase64: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_register_text")
    val loginScreenRegisterText: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_remember_me_label")
    val loginScreenRememberMeLabel: String = KEY_EMPTY_STRING_DEFAULT,
    @SerializedName("login_screen_secret_label")
    val loginScreenSecretLabel: String = KEY_EMPTY_STRING_DEFAULT
)