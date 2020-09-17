package com.example.javatokotlin.common

import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "dd.MMM.yy HH:mm"
fun Date.format(): String =
        SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
                .format(this)

