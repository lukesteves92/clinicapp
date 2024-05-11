package com.inspirecoding.clinicapp.extensions

import java.net.URLDecoder
import java.nio.charset.StandardCharsets

fun String.decode(): String = URLDecoder.decode(this, StandardCharsets.UTF_8.toString())