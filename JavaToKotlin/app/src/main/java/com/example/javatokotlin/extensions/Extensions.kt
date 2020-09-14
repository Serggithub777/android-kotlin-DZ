package com.example.javatokotlin.extensions

import android.content.Context
import android.graphics.Color.WHITE
import androidx.core.content.ContextCompat
import com.example.javatokotlin.R
import com.example.javatokotlin.data.entity.Note
import com.example.javatokotlin.data.entity.Note.Color.WHITE
import com.google.type.Color
import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "dd.MMM.yy HH:mm"
fun Date.format(): String =
        SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
                .format(this)

