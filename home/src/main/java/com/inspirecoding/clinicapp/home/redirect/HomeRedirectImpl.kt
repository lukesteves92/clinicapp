package com.inspirecoding.clinicapp.home.redirect

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.inspirecoding.clinicapp.core.redirect.HomeRedirect
import com.inspirecoding.clinicapp.home.main.HomeActivity

class HomeRedirectImpl : HomeRedirect {
    override fun redirectToHome(context: Context) {
        val currentContext = context as Activity
        currentContext.startActivity(Intent(context, HomeActivity::class.java))
        currentContext.finish()
    }
}